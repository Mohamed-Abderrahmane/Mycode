package formesGeometriques;

public class Rectangle implements FormeGeometrique{
	
	private double longueur;
	protected double largeur;
		
	
	public Rectangle(double longueur, double largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public double aire() {
		return longueur*largeur;
	}
	
	public double perimetre() {
		return 2*(longueur+largeur);
	}
	

}
