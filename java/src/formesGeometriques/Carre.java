package formesGeometriques;

public class Carre extends Rectangle {

	public Carre( double largeur) {
		super(largeur, largeur);

	}


	public double aire() {
		return super.aire();
	}

	public double perimetre() {
		return super.perimetre();
	}


	@Override
	public String toString() {
		return "Carre [] ayant "+largeur+" pour largeur";
	}


	
	
	
	
}
