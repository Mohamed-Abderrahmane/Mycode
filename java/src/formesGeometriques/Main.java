package formesGeometriques;

public class Main {
	
	public static FormeGeometrique grandPerimetre(FormeGeometrique[] formes) {
		double maxPerimetre = 0;
		FormeGeometrique indice = formes[0];
		for(int i = 0;i < formes.length;i++) {
			if(formes[i].perimetre()>= maxPerimetre) {
				maxPerimetre = formes[i].perimetre();
				indice = formes[i];
			}
		}
		return indice;
		
	}
	public static double sommeSurface(FormeGeometrique[] formes) {
		double somme = 0;
		for(int i = 0;i < formes.length;i++) {
			somme += formes[i].aire();
		}
		return somme;
	}

	
	
	public static void main(String[] args) {
		
		//Carre a = new Carre(6);
		
		FormeGeometrique[] f = new FormeGeometrique[4];
		f[0] = new TriangleEquilateral(3,2);
		f[1] = new Carre(9);
		f[2] = new Rectangle(5,2);
		f[3] = new Cercle(3.0);
		
		System.out.println(grandPerimetre(f));
		System.out.println(sommeSurface(f));

		
	}
}
