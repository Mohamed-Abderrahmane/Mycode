package ferry;

import java.util.Arrays;

public class Ferry {

	protected Parking[] listeParking;
	private double poidsMax;
	public Ferry(Parking[] listeParking, double poidsMax) {
		super();
		this.listeParking = listeParking;
		this.poidsMax = poidsMax;
	}
	public Parking[] getListeParking() {
		return listeParking;
	}
	public void setListeParking(Parking[] listeParking) {
		this.listeParking = listeParking;
	}
	public double getPoidsMax() {
		return poidsMax;
	}
	public void setPoidsMax(double poidsMax) {
		this.poidsMax = poidsMax;
	}
	

	public double calculcharge() {
		double Charge = 0;
		for(int i = 0; i<listeParking.length;i++) {
			Charge+= listeParking[i].calculCharge();
		}
		return Charge;
	}
	
	
	public boolean ajoutVehicule(Vehicule a){
		boolean r = false;
		if(a.poidsEnCharge()+ this.calculcharge()<= poidsMax) {
			for(int i = 0;i<listeParking.length;i++) {
				
				if(listeParking[i].entree(a)) {
					r = true;
					System.out.println("Véhiculé ajouté !");
					i= listeParking.length-1;
				}
				else {
					
					System.out.println( listeParking[i].toString()+" ne peut pas recevoir le véhicule ");
				}
			
			}
			if(r = false) {
				System.out.println("Le véhicule n'a pas etre ajouté");
			}
			
		}
		return r;
		
	}
	@Override
	public String toString() {
		return "Ferry [listeParking=" + Arrays.toString(listeParking) + ", poidsMax=" + poidsMax
				+ ", getListeParking()=" + Arrays.toString(getListeParking()) + ", getPoidsMax()=" + getPoidsMax()
				+ ", calculcharge()=" + calculcharge() + "]";
	}
	
	
}
