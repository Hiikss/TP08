package fr.eni.javaee.suividesrepas.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la date et l'heure ne respectent pas les règles définies
	 */
	public static final int REGLE_REPAS_DATE_ERREUR=20000;
	/**
	 * Echec quand les aliments ne repsectent pas les règles définies
	 */
	public static final int REGLE_REPAS_ALIMENTS_ERREUR=20001;

}
