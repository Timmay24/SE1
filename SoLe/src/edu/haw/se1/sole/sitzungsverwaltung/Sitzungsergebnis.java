package edu.haw.se1.sole.sitzungsverwaltung;

import java.util.ArrayList;
import java.util.List;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;

public class Sitzungsergebnis {
	
	private List<IFragenloesung> loesungen;
	private ProzentTyp rating;

	public Sitzungsergebnis() {
		this.setLoesungen(new ArrayList<>());
	}
	
	public void rateAndSaveLoesung(IFragenloesung fragenLoesung) {
		fragenLoesung.rateLoesung();
		this.getLoesungen().add(fragenLoesung);
	}
	
	public ProzentTyp rateSitzung() {
		double rating = 0.0;
		double pointsOverall = 0.0;
		for (IFragenloesung loesung : getLoesungen()) {
			rating += loesung.getRating().getPercent() * loesung.getSchwierigkeitsgrad().getSchwierigkeit();
			pointsOverall += loesung.getSchwierigkeitsgrad().getSchwierigkeit(); 
		}
		rating /= pointsOverall;
		this.setRating(new ProzentTyp(rating));
		return this.getRating();
	}
	
	public ProzentTyp getRating() {
		return rating;
	}

	protected void setRating(ProzentTyp rating) {
		this.rating = rating;
	}

	public List<IFragenloesung> getLoesungen() {
		return loesungen;
	}

	protected void setLoesungen(List<IFragenloesung> loesungen) {
		this.loesungen = loesungen;
	}

}
