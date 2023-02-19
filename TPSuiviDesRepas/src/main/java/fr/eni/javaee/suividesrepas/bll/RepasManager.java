package fr.eni.javaee.suividesrepas.bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bo.Repas;
import fr.eni.javaee.suividesrepas.dal.DAOFactory;
import fr.eni.javaee.suividesrepas.dal.RepasDAO;

public class RepasManager {

	private RepasDAO repasDAO;
	
	public RepasManager() {
		repasDAO = DAOFactory.getRepasDAO();
	}
	
	public void ajouterRepas(LocalDate date, LocalTime heure, List<String> listeAliments) throws BusinessException {
		
	}
	
	public List<Repas> selectRepas() throws BusinessException {
		return this.repasDAO.select();
	}
}
