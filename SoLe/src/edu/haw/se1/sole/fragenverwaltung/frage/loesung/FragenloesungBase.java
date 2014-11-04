package edu.haw.se1.sole.fragenverwaltung.frage.loesung;

import java.util.Date;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;


public abstract class FragenloesungBase implements IFragenloesung {
	
	protected ProzentTyp rating;
	protected IFrage frage;
	protected Date bearbeitungsDatum;

	protected FragenloesungBase() {
	}

	public ProzentTyp getRating() {
		return rating;
	}

	public void rateLoesung() {
		this.rating = frage.rateLoesung(this);
	}

	public IFrage getFrage() {
		return frage;
	}

	protected void setFrage(IFrage frage) {
		this.frage = frage;
	}
	
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad() {
		return frage.getSchwierigkeitsgrad();
	}
	
	public Date getBearbeitungsDatum() {
		return bearbeitungsDatum;
	}
	
	protected void setBearbeitungsDatum(Date datum) {
		this.bearbeitungsDatum = datum;
	}
}
