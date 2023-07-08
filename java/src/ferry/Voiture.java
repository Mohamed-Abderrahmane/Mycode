package ferry;

public class Voiture extends Vehicule {

	private double poidsTotPassager;

	public Voiture(String numImmatriculation, double poidsAvide, double longueur, double largeur, double hauteur,
			double poidsTotPassager) {
		super(numImmatriculation, poidsAvide, longueur, largeur, hauteur);
		this.poidsTotPassager = poidsTotPassager;
	}
	
	
	public double getPoidsTotPassager() {
		return poidsTotPassager;
	}


	public void setPoidsTotPassager(double poidsTotPassager) {
		this.poidsTotPassager = poidsTotPassager;
	}


	public double poidsEnCharge() {
		return this.poidsAvide +  poidsTotPassager;
	}


	@Override
	public String toString() {
		return "Voiture Immatriculation " + getNumImmatriculation() ;
	}
	
	
}
