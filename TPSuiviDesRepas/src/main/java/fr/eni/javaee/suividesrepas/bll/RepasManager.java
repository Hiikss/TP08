package fr.eni.javaee.suividesrepas.bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bo.Aliment;
import fr.eni.javaee.suividesrepas.bo.Repas;
import fr.eni.javaee.suividesrepas.dal.DAOFactory;
import fr.eni.javaee.suividesrepas.dal.RepasDAO;

public class RepasManager {

	private RepasDAO repasDAO;
	
	public RepasManager() {
		repasDAO = DAOFactory.getRepasDAO();
	}
	
	public Repas ajouterRepas(LocalDate date, LocalTime heure, List<String> listeAliments) throws BusinessException {
		BusinessException be = new BusinessException();
		
		Repas repas = null;
		
		if(!be.hasErreurs()) {
			repas = new Repas();
			repas.setDate(date);
			repas.setHeure(heure);
			for(String aliment : listeAliments) {
				repas.getAliments().add(new Aliment(aliment));
			}
			this.repasDAO.insert(repas);
		}
		else {
			throw be;
		}
		return repas;
	}
	
	public List<Repas> selectRepas() throws BusinessException {
		return this.repasDAO.select();
	}
}
