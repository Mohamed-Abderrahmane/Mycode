package formesGeometriques;

public class Cercle implements FormeGeometrique {

	private double rayon;
	
	public Cercle(Double rayon) {
		this.rayon = rayon;
	}

	public double getRayon() {
		return rayon;
	}
	
	public double aire() {
		return Math.PI*Math.pow(rayon, 2);
	}
	public double perimetre() {
		return 2*Math.PI*rayon;
	}
	
	
	
	
	
}
