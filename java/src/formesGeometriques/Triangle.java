package formesGeometriques;

public abstract class Triangle implements FormeGeometrique {

	private double base;
	private double hauteur;
	public Triangle(double base, double hauteur) {
		
		this.base = base;
		this.hauteur = hauteur;
	}
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	public double aire() {
		return base*hauteur/2;
	}
	public abstract double perimetre();
	
}
