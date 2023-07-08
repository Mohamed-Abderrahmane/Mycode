from urllib.request import urlopen
import json
import re
from PIL import Image

###     Ci-dessous, on lit le fichier json de chaque image.

annexe = []
fichiersImage = []
ur ="https://vislab.isr.tecnico.ulisboa.pt/wp-json/wp/v2/media/"
cle = 2119
urlExiste = True
fichiers = []
while urlExiste :
    try :   
        url = ur + str(cle)
        page = urlopen(url)
        fichiersImage.append(url)
    except :
        if(cle < 2146):
            cle = 2146
            continue
        else:
            urlExiste = False
    else :
        html_bytes = page.read()
        html = html_bytes.decode("utf-8")
        fichiers.append(json.loads(html))
        
        cle+=1
        continue
    break
annexe = fichiers
### Là on agrege pour chaque image l'ensemble des liens
urls = []
di = {}
for fichier in fichiers :
    id = fichier['id']
    thumbnail = fichier['media_details']['sizes']['thumbnail']['source_url']
    medium = fichier['media_details']['sizes']['medium']['source_url']
    postthumbnail = fichier['media_details']['sizes']['post-thumbnail']['source_url']
    homecat = fichier['media_details']['sizes']['homecat']['source_url']
    full = fichier['media_details']['sizes']['full']['source_url']
    di[id] = [thumbnail,medium,postthumbnail,homecat,full]


#print(fichiers)
####              Ici, on va créer les dictionnaire qui associent à chaque id d'un fichier json l'ensemble des arrays des images correspondants 

img = {}
for k in di.keys() :
    img[k] = []
    for url in di[k]:
        try :
            imag = Image.open(urlopen(url))
        except :
            print("le fichier n'est pas accessible")
        else :
            im = list(imag.getdata())
            imName = re.sub("https://vislab.isr.tecnico.ulisboa.pt/wp-content/uploads/2015/07/",'',url)
            #imag.save('images/{}'.format(imName))
            img[k].append(im)  
        
#print(img)
#print(img[2119])


##################              ANNEXES

annexesDict = {}
annexesFichiers = {}

for an in annexe:
    ids = an['id']
    print( ids)
    auteur = an['_links']['author'][0]['href']
    print("ceci n'a pas marché  ")
    replies = an['_links']['replies'][0]['href']
    print("Ceci est atteint")
    annexesDict[ids] = [auteur,replies]
for ke in annexesDict.keys(): 
    annexesliste = annexesDict[ke]
    annexesdossier =''
    for f in annexesliste:
        try :   
            pages = urlopen(f)
        except :
            print("L'url n'est pas accessible")
        else :
            Annexes_html_bytes = pages.read()
            Annexes_html = Annexes_html_bytes.decode("utf-8")
            annexesdossier += str(json.loads(Annexes_html))     
    annexesFichiers[ke] = annexesdossier
#print(fichiers)


###             La on va essayer d'associer les images avec le json correspondant 
ensembleDonnées={}
for fiche in fichiers:
    ensembleDonnées[fiche['id']]=re.sub("\"id:\d+,",'',str(fiche)) 
#print(ensembleDonnées)


Ensemble = {}
for key in ensembleDonnées.keys():
    strCodeImages = ''
    for i in img[key]:
        strCodeImages += str(i)
    Ensemble[key]=ensembleDonnées[key]+annexesFichiers[key]+strCodeImages
with open("metaDonneesEtimages.json", "w") as outfile:
    json.dump(Ensemble, outfile)
    