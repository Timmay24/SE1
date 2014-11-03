package edu.haw.se1.sole.sitzungsverwaltung;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageBase;

public class Pruefung {

	private Map<Integer, FrageBase> pruefungsFragen;
	private List<IFragenloesung> loesungen;
	private ProzentTyp rating;

	public Pruefung(Map<Integer, FrageBase> pruefungsFragen) {
		this.pruefungsFragen = pruefungsFragen;
		this.loesungen = new ArrayList<>();
	}
	
	public void rateAndSaveLoesung(IFragenloesung fragenLoesung) {
		fragenLoesung.rateLoesung();
		this.loesungen.add(fragenLoesung);
	}
	
	public ProzentTyp ratePruefung() {
		double rating = 0.0;
		for (IFragenloesung loesung : loesungen) {
			rating += loesung.getRating().getPercent();
		}
		rating /= loesungen.size();
		this.setRating(new ProzentTyp(rating));
		return this.getRating();
	}

	public ProzentTyp getRating() {
		return rating;
	}

	private void setRating(ProzentTyp rating) {
		this.rating = rating;
	}

}
