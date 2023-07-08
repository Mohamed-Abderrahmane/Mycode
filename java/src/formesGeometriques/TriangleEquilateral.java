package formesGeometriques;

public class TriangleEquilateral extends Triangle{

	public TriangleEquilateral(double base, double hauteur) {
		super(base, hauteur);
	}

	public double aire() {
		return super.aire();
	}
	public double perimetre() {
		return this.getBase()*3;
	}
	
}
