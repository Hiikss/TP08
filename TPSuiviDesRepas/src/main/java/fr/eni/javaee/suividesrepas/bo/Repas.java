package fr.eni.javaee.suividesrepas.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Repas {
	
	private int id;
	private LocalDate date;
	private LocalTime heure;
	private List<Aliment> aliments;
	
	public Repas() {
		this.aliments = new ArrayList<>();
	}
	
	public Repas(int id, LocalDate date, LocalTime heure, List<Aliment> aliments) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.aliments = aliments;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getHeure() {
		return heure;
	}
	
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	
	public List<Aliment> getAliments() {
		return aliments;
	}
	
	public void setAliments(List<Aliment> aliments) {
		this.aliments = aliments;
	}
	
}
