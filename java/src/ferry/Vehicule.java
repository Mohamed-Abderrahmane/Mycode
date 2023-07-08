/**
 * 
 */
package ferry;

/**
 * @author moham
 *
 */
public abstract class Vehicule implements Comparable<Vehicule> {

	private String numImmatriculation;
	protected double poidsAvide;
	private double longueur;
	private double largeur;
	private double hauteur;
	public Vehicule(String numImmatriculation, double poidsAvide, double longueur, double largeur, double hauteur) {
		
		this.numImmatriculation = numImmatriculation;
		this.poidsAvide = poidsAvide;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	public String getNumImmatriculation() {
		return numImmatriculation;
	}
	public void setNumImmatriculation(String numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}
	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	

	public int compareTo(Vehicule a) {
		
		if(this.hauteur<a.hauteur) {
			return -1;
		}
		else {
			if(this.hauteur>a.hauteur){
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	
	
	public abstract double poidsEnCharge();
	

}
