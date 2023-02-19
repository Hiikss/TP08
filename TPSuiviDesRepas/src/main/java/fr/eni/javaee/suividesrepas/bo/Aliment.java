package fr.eni.javaee.suividesrepas.bo;

import java.io.Serializable;

public class Aliment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	
	public Aliment(String nom) {
		super();
		this.nom = nom;
	}
	
	public Aliment(int id, String nom) {
		this(nom);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
