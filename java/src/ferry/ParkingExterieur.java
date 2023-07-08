package ferry;

public class ParkingExterieur extends Parking{

	public ParkingExterieur(int nbPlaces, Vehicule[] listeVehicules) {
		super(nbPlaces, listeVehicules);
	}


	public boolean entree(Vehicule a) {
		boolean res = false;
		this.listeVehicules  = new Vehicule[this.listeVehicules.length+1];
		 if(listeVehicules.length<=nbPlaces) {
			 for (int i = 0; i <listeVehicules.length -1; i++) {
				 listeVehicules[i] = this.listeVehicules[i];
			 }
			 for (int i = listeVehicules.length-1; i <listeVehicules.length; i++) {
				 listeVehicules[i] = a;
			 }
			 System.out.println(a +" a été bien garé");
			 res = true;
		 }
		 else {
			 System.out.println("Le parking extérieur est plein");
			 res = false;
		 }
		 
		return res;
	}

	
	public boolean sortie(Vehicule a) {
		boolean res = false;
		Vehicule [] listeVehicules  = new Vehicule[this.listeVehicules.length-1];
		 for (int i = 0; i <listeVehicules.length; i++) {
			 if(listeVehicules[i]!=a) {
				 listeVehicules[i] = listeVehicules[i];
				 res = false;
			 }
			 else {
				 i++;
				 res = true;
			 }
		 }
		 return res;
		 
	}


	

	
	
}
