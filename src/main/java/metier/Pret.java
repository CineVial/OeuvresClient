package metier;

import java.io.Serializable;
import java.util.Date;

public class Pret implements Serializable {

	private Date date;
	private int duree;
	private Oeuvrepret oeuvrepret;
	private Adherent adherent;

	
	public Pret( Date date, int duree, Oeuvrepret oeuvrepret, Adherent adherent) {
		super();
		this.date = date;
		this.duree = duree;
		this.oeuvrepret = oeuvrepret;
		this.adherent = adherent;
	}

	public Pret() {
	}


	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Oeuvrepret getOeuvrepret() {
		return this.oeuvrepret;
	}

	public void setOeuvrepret(Oeuvrepret oeuvrepret) {
		this.oeuvrepret = oeuvrepret;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

}