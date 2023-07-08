package bd.dao;

import java.util.ArrayList;

public abstract class DAO<E> {
	
	//Lecture de tous les éléments de la table

	public abstract ArrayList<E> readAll() throws Exception;
	
}
