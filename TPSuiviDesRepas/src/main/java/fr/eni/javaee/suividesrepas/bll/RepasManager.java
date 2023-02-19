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
		this.validerDate(date, heure, be);
		this.validerAliments(listeAliments, be);
		
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

	private void validerDate(LocalDate date, LocalTime heure, BusinessException be) {
		if(date==null || heure==null || date.isAfter(LocalDate.now()) && heure.isAfter(LocalTime.now())) {
			be.ajouterErreur(CodesResultatBLL.REGLE_REPAS_DATE_ERREUR);
		}
	}
	
	private void validerAliments(List<String> listeAliments, BusinessException be) {
		if(listeAliments==null || listeAliments.size()==0) {
			be.ajouterErreur(CodesResultatBLL.REGLE_REPAS_ALIMENTS_ERREUR);
		}
		
	}
}
