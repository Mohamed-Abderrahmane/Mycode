# Exercice 1

def mention(moyenne) :
    if(moyenne > 10) :
        if(moyenne >= 16) :
            avis ="l'étudiant a une mention très bien"
        elif(moyenne <   14) :
            avis = "l'étudiant a une mention assez-bien"

        elif(moyenne < 16) :
            avis="l'étudiant a une mention bien"
        else:
            avis = "l'étudiant n'a pas de mention"
    else: 
        avis="il n'a pas la moyenne"
    return avis




# Exercice 2 :
from cmath import sqrt
import math
def premier(a):
    diviseur = 1
    sommDiviseur = 0 
    while(diviseur < math.sqrt(a) + 1 ) :
        if((a % diviseur) == 0): 
            sommDiviseur += 2
            diviseur +=1
    if(sommDiviseur == 2 ):
        print(a, " est un nombre premier")
    else:
        print(a, "n'est pas premier")


        


# Exercice 3 :
def estParfait(nb):
    somme= 0
    for diviseur in range (1,math.sqrt(nb)+1, 1):
        if ((nb % diviseur) == 0) :
            somme = somme + diviseur + nb/diviseur

    if( (somme/2) == nb):
        print(nb," est un nombre parfait")
    else:
        print(nb, " n'est pas un nombre parfait")
	
# Exercice 2 republicains vs democrates
from pandas import pd
df  = pd.read_csv('vote.csv',index =["Sénateur"])
df


































