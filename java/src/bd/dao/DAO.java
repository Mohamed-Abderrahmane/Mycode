package bd.dao;

import java.util.ArrayList;

public abstract class DAO<E> {
	
	//Lecture de tous les �l�ments de la table

	public abstract ArrayList<E> readAll() throws Exception;
	
}
