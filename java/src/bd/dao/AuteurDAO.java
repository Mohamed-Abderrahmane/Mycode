package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bd.metier.Auteur;

public class AuteurDAO extends DAO<Auteur>{

	
	public ArrayList<Auteur> readAll() throws Exception{
		Connection cx;
	// connexion
		try {
			cx = Bd.getInstance();
		}
		catch(Exception e){
			throw e;
		}
		
		
		
		// ouverture espace requete
		
		String sql = "SELECT * FROM Auteur";
		
		ArrayList<Auteur> liste = new ArrayList<Auteur>();
		
		try(PreparedStatement st = cx.prepareStatement(sql)){
			//Execution de l arequete
			ResultSet rs = st.executeQuery();
			
			// Lecture du résultat 
			while(rs.next()) {
				liste.add(new Auteur(rs.getInt("Numero"),rs.getNString(2),rs.getString("Prenom")));
			}
			return liste;
		}
		
		
		
	}
	
}
