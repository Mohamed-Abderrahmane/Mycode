package fileAttente;

import java.util.ArrayList;

public class FileAttente<E> {

	// proprietes
	private int capacite;
	private ArrayList<E> liste;
	
	// Constructeur
	public FileAttente(int capacite) {
		this.capacite = capacite;
	}
	
	//	Méthodes
	
	public boolean addElement ( E nom) {
		if(this.liste.size()< this.capacite) {
			this.liste.add(nom);
			return true;
		}
		else {
			return false;
		}
	}
	
	public E removeElement() {
		return this.liste.remove(0);
	}
	
	public static void main(String[] a) 
	{
		FileAttente<String> tp = new FileAttente<>(10);
		tp.addElement("abc");
		String ch = "def";
		tp.addElement(ch);
		tp.addElement("mno");
		
	}
	
	
	
}
