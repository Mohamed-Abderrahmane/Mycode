package ferry;

public class Main {

	public static void main(String[] args) {
		
		
		Bus a = new Bus("123BV",25,4,5,6,54,34);
		Bus b = new Bus("124SQ",25,4,5,6,57,31);
		Voiture c = new Voiture("98WZ",13,3,2,1,14);
		Voiture d = new Voiture("74DM",13,3,3,2,10);
		Camion e = new Camion("203",30,5,3,3,50);
		Camion f = new Camion("205IP",30,5,3,3,65);
		Voiture j = new Voiture("12A",14,5,3,3,15);
		Camion l = new Camion("245GH",34,5,3,3,70);


		
		Vehicule[] listeA = {a,c,d};
		Vehicule[] listeB = {e,f};
		Vehicule[] listeC = {b,j,l};
		
		
		
		
		
		Couloir g = new Couloir(5,listeA,5);
		ParkingExterieur m = new ParkingExterieur(5,listeC);
		Garage n = new Garage(3,listeB,2);
		
		
		Parking[] listeP = {g,m,n};
		
		Ferry G = new Ferry(listeP,1000);
		
		//G.ajoutVehicule(l);
		
		for(int i =0;i<G.getListeParking().length;i++) {
			System.out.println("Le parking " + G.listeParking[i].toString()+ " : nbPlaces = "+G.listeParking[i].nbPlaces + " ::: " );

			for(int q = 0; q< G.listeParking[i].listeVehicules.length;q++) {
				System.out.print("\""+ G.listeParking[i].listeVehicules[q].getNumImmatriculation()+ "\" , ");
				
			}
			
		}
	
	}

}
