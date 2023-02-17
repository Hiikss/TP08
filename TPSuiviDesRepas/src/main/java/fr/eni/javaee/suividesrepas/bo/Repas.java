package fr.eni.javaee.suividesrepas.bo;

public class Repas {
	
	private static final String INSERT_REPAS = "INSERT INTO REPAS(date_repas, heure_repas) VALUES(?,?)";
	private static final String INSERT_ALIMENT = "INSERT INTO ALIMENTS(nom_aliment, id_repas) VALUES(?,?)";
}
