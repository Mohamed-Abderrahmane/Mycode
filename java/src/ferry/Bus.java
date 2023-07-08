package ferry;

public class Bus extends Vehicule{

	private double poidsPassagers;
	private double poidsBagages;
	public Bus(String numImmatriculation, double poidsAvide, double longueur, double largeur, double hauteur,
			double poidsPassagers, double poidsBagages) {
		super(numImmatriculation, poidsAvide, longueur, largeur, hauteur);
		this.poidsPassagers = poidsPassagers;
		this.poidsBagages = poidsBagages;
	}
	public double getPoidsPassagers() {
		return poidsPassagers;
	}
	public void setPoidsPassagers(double poidsPassagers) {
		this.poidsPassagers = poidsPassagers;
	}
	public double getPoidsBagages() {
		return poidsBagages;
	}
	public void setPoidsBagages(double poidsBagages) {
		this.poidsBagages = poidsBagages;
	}
	
	public double poidsEnCharge() {
		return (poidsPassagers + poidsBagages + this.poidsAvide);
	}
	@Override
	public String toString() {
		return "Bus Immatriculation " + getNumImmatriculation();
	}
	
	
	
	
}
