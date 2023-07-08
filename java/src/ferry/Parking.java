package ferry;

import java.util.Arrays;

public abstract class Parking {

	protected int nbPlaces;
	protected Vehicule[] listeVehicules;
	
	
	public Parking(int nbPlaces, Vehicule[] listeVehicules) {
		this.nbPlaces = nbPlaces;
		this.listeVehicules = listeVehicules;
	}
	
	public double calculCharge() {
		double a =0;
		for(int i = 0; i<listeVehicules.length;i++) {
			a+= listeVehicules[i].poidsEnCharge();
		}
		return a;
	}
	public double placeLibres() {
		return nbPlaces-listeVehicules.length;
	}
	public abstract boolean entree(Vehicule a);
	public abstract boolean sortie(Vehicule a);

		@Override
	public String toString() {
		return "Parking [nbPlaces=" + nbPlaces + ", listeVehicules=" + Arrays.toString(listeVehicules)
				+ ", placeLibres" + placeLibres() + "]";
	}

}
