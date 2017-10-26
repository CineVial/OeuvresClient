package metier;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
	
	private Date date;
	private Adherent adherent;
	private Oeuvrevente oeuvrevente;

	public Reservation() {
	}



	public Reservation(Date date, Adherent adherent, Oeuvrevente oeuvrevente) {
		super();
		this.date = date;
		this.adherent = adherent;
		this.oeuvrevente = oeuvrevente;
	}



	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Oeuvrevente getOeuvrevente() {
		return this.oeuvrevente;
	}

	public void setOeuvrevente(Oeuvrevente oeuvrevente) {
		this.oeuvrevente = oeuvrevente;
	}

}