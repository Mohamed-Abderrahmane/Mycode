import json
import sqlite3
import re
import pymongo
import zipfile

Path = "archive.zip"

with zipfile.ZipFile(Path, 'r') as zip: 
    # extraire tous les fichiers vers un autre répertoire
   zip.extractall('donneesExtraites')


conn = sqlite3.connect( "donneesExtraites\database.sqlite" )
conn.row_factory = sqlite3.Row # This enables column access by name: row['column_name'] 
db = conn.cursor()

rows = db.execute('''
SELECT * from May2015 
''').fetchall()

conn.commit()
conn.close()

commentaires = {}
CommentsDict = []
for row in rows:
    CommentsDict.append((dict(row)))

###with open("CommentairesReddit.json", "w") as outfile:
 #   json.dump(CommentsJson, outfile)

idParents = []
comments ={}
for c in CommentsDict:
    idParents.append(c["parent_id"])
#print(len(idParents))
idsParParents ={}
commentaire = {}
for a in CommentsDict:
    commentaire[a["id"]]= re.sub("\, \'id\': \'\S+\'\,"," ",str(a))
for idparent in idParents:
    comments[idparent] = []
    idsParParents[idparent]=[]
    for comment in CommentsDict:
        if comment["parent_id"] == idparent :
            idsParParents[idparent].append(comment["id"])
            comments[idparent].append(comment)
#print(idsParParents)

def traitement(idp):
    for i in idsParParents.keys():
        if i in idsParParents[idp]:
            idsParParents[idP].remove(i)
            idajout = i +":"+"{"+idsParParents[i]+"}"
            idsParParents[idp].append(idajout)


etudie={}
for id in idsParParents.keys():
    traitement(id)
    etudie[id] = False
while(True):
    if False in etudie.values():
        for idP in idsParParents.keys():
            for idFils in idsParParents[idP]:
                if idFils in idsParParents.keys():
                        traitement(idFils)
                        idajoute = idFils +":{"+ idsParParents[idFils]+"}"
                        idsParParents[idP].remove(idFils)
                        idsParParents[idP].append(idajoute)
                        del idsParParents[idFils]
                        etudie[idFils]==True   
            etudie[idP] = True
    else:
        break        


myclient = pymongo.MongoClient("mongodb://mabder:<M_Abderrahmane17@>@ac-ahgfrpo-shard-00-00.rm9zwa3.mongodb.net:27017,ac-ahgfrpo-shard-00-01.rm9zwa3.mongodb.net:27017,ac-ahgfrpo-shard-00-02.rm9zwa3.mongodb.net:27017/?ssl=true&replicaSet=atlas-6r8s79-shard-0&authSource=admin&retryWrites=true&w=majority")
mydb = myclient["Commentaires"]
mycol = mydb["commentMay2015"]
dictStr = json.dumps(idsParParents)
for key, value in commentaire.items():
    value = re.sub("\, \'parent_id\': \'.+\'"," ",value)
    valeur = key+":"+value
    dictStr = re.sub(key,valeur,dictStr)

x = mycol.insert_one(dict(dictStr))

# on affiche les 5 premiers documents sans les _id
for x in mycol.find({},{ "_id": 0}).limit(5):
  print(x)


#print(dictStr)

####            Diviser les body des commentaires en plusieurs lignes.

lignesParcommentaire = {}
for r in CommentsDict:
    lignesParcommentaire[r["id"]]= str(r["body"]).split(". ")
print(lignesParcommentaire)
