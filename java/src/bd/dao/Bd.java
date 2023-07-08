package bd.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.metier.Auteur;

import java.sql.DriverManager;

public class Bd {

	/**
	 * @param args
	 */

	private static final String URL = "jdbc:mysql://localhost:3307/db_21807865";
	private static final String LOGIN = "21807865";
	private static final String PWD = "S01675";

	private static Connection cx;

	/**
	 * @throws Exception 
	 * @throws exceptions
	 */
	
	public static Connection getInstance() throws Exception {
		if (cx==null) {
			Bd.connection();
			return cx;
			}
		return cx;
	}
	private static void connection() throws Exception
	{
		// Chargement du pilote
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException cnf)
		{
			throw new Exception("bd.dao.Bd.BD() - Chargement du driver - " + cnf.getMessage());
		}

		//Connexion
		try
		{
			cx = DriverManager.getConnection(URL, LOGIN, PWD);
		}
		catch (SQLException sqle)
		{
			throw new Exception ("bd.dao.Bd.BD() - Connexion - " + sqle.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			AuteurDAO  auteurdao = new AuteurDAO();
			ArrayList<Auteur> l = auteurdao.readAll();
			for (Auteur a:l) {
				System.out.println(a);
			}
		}
		catch (Exception e)
		{
			System.out.println("Connexion échouée !");
			System.out.println(e.getMessage());
		}
	}
}



