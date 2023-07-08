package bd.metier;

public class Auteur {
	
	private int NumAuteur;
	private String nom;
	private String prenom;
	
	// Constructeurs
	public Auteur(int NumAuteur, String nom, String prenom) {
		super();
		this.NumAuteur = NumAuteur;
		this.nom = nom;
		this.prenom= prenom;
	}
	
	public Auteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom= prenom;
	}

	public int getNumAuteur() {
		return NumAuteur;}
	public void setNumAuteur(int numAuteur) {
		NumAuteur = numAuteur;}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}

	@Override
	public String toString() {
		return "Auteur [NumAuteur=" + NumAuteur + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}
