package polynome;
import java.util.ArrayList;



public class Polynome {

	
	private int taille;
	private double[][] coeffs = new double[2][taille];
	
	/**
	 * Construction à partir d'un autre polynome
	 * **/
	
	public Polynome(Polynome a) {
		for(int i = 0;i<= a.getCoeffs().length;i++) {
			this.coeffs[i] = a.coeffs[i];		}
	}
	public Polynome(int taille,double[][] coeffs) {
		super();
		this.taille = taille;
		this.coeffs = coeffs;
	}
	public double[][] getCoeffs() {
		return coeffs;
	}
	public void setCoeffs(double[][] coeffs) {
		this.coeffs = coeffs;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	@Override
	public String toString() {
		/* [
		 * 	[1,2], // Coefficient
		 *  [3, 4], // exposant 
		 * ]
		 */
		
		int nbColonnes = this.coeffs[0].length;
		int nbLignes = 2;
		
		String affichage = "";
		boolean premier_tour = true;
		for (int i_colonne = 0; i_colonne <nbColonnes; i_colonne++ ) {
			affichage += "(";
			for (int i_ligne=0; i_ligne <nbLignes; i_ligne++) {
				affichage+=this.coeffs[i_ligne][i_colonne];
				if(premier_tour) {
					affichage += ", ";
				}
				premier_tour = !premier_tour;
			}
			affichage += ") ";
		}
		
		return affichage;
	}
	/*
	 * 
	 * Retourne le degrès du polynôme.

	 */
	
	public double degre() {
		double degre = 0;
		for(int i = 0;i<= this.getCoeffs().length;i++) {
			if(this.getCoeffs()[1][i]>degre) {
				degre = this.getCoeffs()[1][i];
			}
		}
		return degre;
	}
	/*
	 * 
	 * 	Retourne la valeur du polynôme en fonction d'une valeur donnée.

	 */
	
	
	public double getValeur(double a) {
		double resultat =0;
		for(int i = 0;i<= this.getCoeffs().length;i++) {
			resultat += this.getCoeffs()[0][i]*Math.pow(a, this.getCoeffs()[1][i]);
		}
		return resultat;
	}
	
	/*
	 * 
	 * Ajoute un polynome au polynome courant "this".

	 */
	
	public Polynome addPolynome(Polynome a) {
		Polynome b = this;
		return sommePolynomes(b,a);
	}
	
	/*
	 * 
	 * Effectue la somme de 2 polynômes en générant un nouveau polynome.

	 * 
	 */
	
	public static Polynome sommePolynomes(Polynome a, Polynome b){
		double[][] A = a.getCoeffs();
		double[][] B = b.getCoeffs();
		int indiceVide = A.length+1;


		int f = a.getTaille();		
		int t = b.getTaille();

		double[][] S = new double[2][f+t];

		for(int k=0;k< A.length+1;k++) {
			S[0][k] = A[0][k];
			S[1][k] = A[1][k];
		}

		for (int c = 0; c < B.length+1; c++) {
			boolean ajout = false;
			for (int j = 0; j < indiceVide+1; j++){
				if(S[1][j] == B[1][c]) {
					S[0][j] += B[0][c];
					ajout = true;
				}
			}
			if(ajout==false) {
				S[0][indiceVide] = B[0][c];
				System.out.println("ajout coefficient");
				S[1][indiceVide] = B[1][c];
				indiceVide +=1;
			}

		}
		for (int j = 0; j < S.length; j++){
			if(S[0][j] == 0.0) {
				S = removeColumnNull(S,j);
			}
		} 
		Polynome p = new Polynome(S.length, S);
		return p;
	}

	/*
	 * 
	 * Recherche et affiche les racines entières d’un polynôme dans un intervalle donné. Une racine r de p est une valeur telle que p(r) = 0.

	 * 
	 */
	
	public int[] racine(int debut, int fin) {
		ArrayList<Integer> p = new ArrayList<Integer>();
		for(int i=debut;i<=fin;i++) {
			if(this.getValeur(i)==0) {
				p.add(i);
			}
		}
		int[] a = new int[p.size()];
		for(int i=0;i<=p.size();i++) {
			a[i] = p.get(i);
		}
		return a;
	}
	
	
	/* Enlever les colonnes nulles				*/
	
	public static double [][] removeColumnNull(double [][] tab, int indice) {
		double[][] newTab = new double[2][tab.length-1];

		for(int i=0; i<indice; i++) {
			newTab[1][i] = tab[1][i];
			newTab[0][i] = tab[0][i];
		}
		for(int i = indice+1; i<tab.length; i++) {

			newTab[1][i] = tab[1][i];
			newTab[0][i] = tab[0][i];
			System.out.println(newTab[i].toString());
		}
		//System.out.println(newTab);

		return newTab;

	}	
}