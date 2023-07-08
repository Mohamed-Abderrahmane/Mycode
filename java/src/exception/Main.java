package exception;

public class Main {
	

	public static void moyenne(String[] ar) {
		double nbNombre= 0;
		double somme = 0;

		for(int i=0; i<ar.length; i++) {
			try {
				somme += Integer.parseInt(ar[i]);
				nbNombre ++;
			}

			catch(Exception nom) {
				System.out.println(ar[i] +" la valeur n'est pas compté, ce n'est pas un chiffre");
			}
		}

		try {
			System.out.println("Moyenne = " + somme/nbNombre);
		}
		catch(ArithmeticException nom) {
			System.out.println("division impossible");
		}

	}

	
	

	public static void main(String[] args) {

		String[] tab = { "9", "6", "1", "4" };
		

		
		double somme = 0;
		try {
			for(int i=0; i<tab.length; i++) {
				somme += Integer.parseInt(tab[i]);
			}

			System.out.println("Moyenne = " + somme/tab.length);	
		}
		catch(Exception nom) {
			System.out.println(nom);
		}
		
		String[] a= { "9", "e", "r", "4" };
		String[] b = { "z", "e", "r", "o" };

		
		moyenne(a);
		moyenne(b);
		

	}

}
