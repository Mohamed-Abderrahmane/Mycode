package ferry;

public class Garage extends Parking {

	
	private double hauteur;
	public Garage(int nbPlaces, Vehicule[] listeVehicules, double hauteur) {
		super(nbPlaces, listeVehicules);
		this.hauteur = hauteur;
	}
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public boolean entree(Vehicule a) {
		boolean res = false;
		if(hauteur> a.getHauteur()) {
			
			this.listeVehicules  = new Vehicule[this.listeVehicules.length+1];
			 if(listeVehicules.length<=this.nbPlaces) {
				 
				 for (int i = 0; i <listeVehicules.length-1; i++) {
					 listeVehicules[i] = this.listeVehicules[i];
				 }
				 for (int i = listeVehicules.length-1; i <listeVehicules.length; i++) {
					 listeVehicules[i] = a;
				 }
				 System.out.println(a +" a été bien garé"); 
				 res = true;
				 
			 }
			 else {
				 System.out.println("Le Garage est plein");
			 }
			 
		}
		else {
			System.out.println("Le véhicule est trop grand pour ce garage");
		}
		return res;
		
	}
	
	public boolean sortie(Vehicule a) {
		int indice = 0; 
		boolean res = false;
		for (int i = listeVehicules.length-1; i >= 0; i--) {
			if(listeVehicules[i]==a) {
				indice = i; 
			}
			else {
				i++;
			}
		}

		if(indice == listeVehicules.length-1) {
			 Vehicule [] listeVehicules  = new Vehicule[this.listeVehicules.length-1];

			for (int i = 0; i <listeVehicules.length-1; i++) {
				listeVehicules[i] = listeVehicules[i] ;
				res= true;

			}
			
		}
		else {
			System.out.println("le véhicule ne pourrait etre enlevé");
		}
		return res;
		
	}

	
	

	
}
