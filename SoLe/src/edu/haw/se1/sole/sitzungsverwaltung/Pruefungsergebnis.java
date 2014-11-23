package edu.haw.se1.sole.sitzungsverwaltung;


import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;

public class Pruefungsergebnis extends Sitzungsergebnis {
	

	public Pruefungsergebnis() {
		super();
	}
	
	public void rateAndSaveLoesung(IFragenloesung fragenLoesung) {
		fragenLoesung.bewerteLoesung();
		this.getLoesungen().add(fragenLoesung);
	}

	public ProzentTyp ratePruefung() {
		return this.rateSitzung();
	}
	
}
