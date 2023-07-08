package polynome;

import java.util.Arrays;

public class Main {

	public static String mention(double moyenne) {
		String avis = "l'étudiant n'a pas de mention";
		if(moyenne > 10) {
			if(moyenne <= 12) {
				return avis;
			}

			else if(moyenne <= 14) {
				avis = "l'étudiant a une mention assez-bien";
			}
			else if(moyenne <= 16) {
				avis="l'étudiant a une mention bien";

			}
			else {
				avis="l'étudiant a une mention très bien";

			}
			

		}
		else {
			avis="l'étudiant n'a pas la moyenne";
		}
		return avis;
	}


	public static String categorieEnfant(int anneeNaissance) {
		String categorie = "Minime";
		switch(anneeNaissance) {
		case 2008 :
		case 2009 :
			categorie = "Minime";
			break;
		case 2010 :
		case 2011 :
			categorie="Benjamin";
			break;
		case 2012 :
		case 2013 :
			categorie="Poussin";
			break;
		case 2014 :
		case 2015:
			categorie= "Mini poussin";
			break;
		case 2016 :
		case 2017 : 
			categorie="Pépinière";
			break;
		case 2018:
		case 2019:
			categorie="Baby";
			break;
		}

		return categorie;

	}

	public static void premier(int a) {

		for( double i = 1; i< a+1 ;i++) {
			int diviseur = 1;
			int sommDiviseur = 0;

			while(diviseur < Math.sqrt(i)+1 ) {
				if((i % diviseur) == 0) {

					sommDiviseur += 2;
				}

				diviseur +=1;
			}
			//System.out.println(sommDiviseur +" de "+ i);

			if(sommDiviseur == 2 ) {
				System.out.println(i+ " est un nombre premier");
			}
		}

	}
	
	public static boolean estParfait(int nbCible) {
		int somme = 0;
		for (int diviseur=1; diviseur<=nbCible; diviseur++) {
			if ((nbCible % diviseur) == 0) {
				somme += diviseur;
			}
		}
		return (somme/2) == nbCible;
	}


	public static void afficherNbParfait(int nbDepart, int nbArrive) {
		for(int nbCible = nbDepart; nbCible<=nbArrive; nbCible++) {
			if(estParfait(nbCible)) {
				System.out.println(nbCible + " est un nombre parfait");
			}
		}
	}
	
	
	public static void tabAleatoireTrie(int tailleTab) {
		
	}
	
	public static boolean verifierAnagrammes(String mot1, String mot2) {
	
		mot1 = mot1.toLowerCase();
		mot2 = mot2.toLowerCase();
		 
		char[] mot1Tab = mot1.toCharArray();
		char[] mot2Tab = mot2.toCharArray();
		
		Arrays.sort(mot1Tab);
		Arrays.sort(mot2Tab);

		return Arrays.equals(mot1Tab,mot2Tab);
	}

	
	public static int pgcd(int a, int b) {
		
	
		if (a==b) {
			return a;
		}
		
		else if (a>b) {
			return pgcd(a-b,b);
		}

		else {
			return pgcd(a,b-a);
		}
	}
	
	public static void trachentberg(int nombre) {
		String nbStr = Integer.toString(nombre);
		//System.out.println(nbStr);
		int[] chiff = new int[nbStr.length()];
		
		int[] resultat = new int[chiff.length];

		for(int i=nbStr.length() - 1; i>=0; i--) {
			String nbst = nbStr.substring(i,i+1);
			int nbrInt = Integer.parseInt(nbst);
			//System.out.println(nbrInt);
			chiff[i] = nbrInt;		
			//System.out.println(chiff[i]);
		}
		//System.out.println(" le tableau des entiers ");

		for(int i= chiff.length-1; i>=0 ; i--) {
			//System.out.println(chiff[i]);
			if(i==chiff.length-1) {
				resultat[i] = 10- chiff[i];
				if(chiff[i] % 2 !=0) {
					resultat[i] = resultat[i] + 5;
				}
			}
			else if(i==0) {
				resultat[i] = chiff[i]/2 -1;
			}
			else {
				resultat[i] = 9-chiff[i] + chiff[i+1]/2;
				if(chiff[i] % 2 != 0) {
					resultat[i] = resultat[i] + 5;
				}
			}
			System.out.println(resultat[i]);
		}

	}

	

	




	public static void main(String[] args) {
		//String a = mention(19);
		//System.out.println(a);

		//System.out.println(categorieEnfant(2011));

		//premier(100);

		//sommeDiviseur(100);
		
		//afficherNbParfait(1,500);
		// System.out.println(verifierAnagrammes("crane","ancre" ));
		// System.out.println(pgcd(23,10));
		//trachentberg(1254);
		//Polynome a = new Polynome(3, [{1, 4, 7},{3, 2, 7}]);
		double[][] a = {{1, 4, 7},{3, 2, 7}};
		Polynome b = new Polynome(3,a);

		double[][] c = {{1, 4, 7},{3, 3, 3}};
		Polynome d = new Polynome(3,c);

//		double[][] = a.setCoeffs([1, 4, 5,{3, 2, 7});
		
		
		//System.out.println(removeColumn(a,1).toString());
		Polynome s = Polynome.sommePolynomes(b,d);
		
		System.out.println(s.toString());
/*		for( int i=0;i<s.getTaille();i++) {
			System.out.println(s.getCoeffs()[i].toString());
			for(int j=0;j<s.getCoeffs()[i].length;j++) {
				s.getCoeffs[i](j);
			}
			
		}
		*/
		
		
	}
}
