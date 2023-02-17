package fr.eni.javaee.suividesrepas.bll;

import fr.eni.javaee.suividesrepas.dal.DAOFactory;
import fr.eni.javaee.suividesrepas.dal.RepasDAO;

public class RepasManager {

	private RepasDAO repasDAO;
	
	public RepasManager() {
		repasDAO = DAOFactory.getRepasDAO();
	}
	
	public void ajouterRepas() {
		
	}
}
