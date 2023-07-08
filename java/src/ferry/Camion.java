package ferry;

public class Camion extends Vehicule {

	private double poidsChargement;

	public Camion(String numImmatriculation, double poidsAvide, double longueur, double largeur, double hauteur,
			double poidsChargement) {
		super(numImmatriculation, poidsAvide, longueur, largeur, hauteur);
		this.poidsChargement = poidsChargement;
	}

	public double getPoidsChargement() {
		return poidsChargement;
	}

	public void setPoidsChargement(double poidsChargement) {
		this.poidsChargement = poidsChargement;
	}

	
	public double poidsEnCharge() {
		return poidsAvide + poidsChargement;
	}

	@Override
	public String toString() {
		return "Camion Immatriculation " + getNumImmatriculation();
	}
	
	
	
	
}
