package edu.haw.se1.sole.fragenverwaltung.frage.loesung;

import java.util.Date;
import java.util.List;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;


public abstract class FragenloesungBase implements IFragenloesung {
	
	protected List<Antwort> loesung;
	protected IFrage frage;
	protected ProzentTyp bewertung;
	protected Date bearbeitungsDatum;

	// muss ggf. noch so erweitert werden, dass direkt bei Erstellung
	// alle Werte gesetzt sind und die Lösung immutable
	protected FragenloesungBase(List<Antwort> loesung, IFrage frage) {
		this.loesung = loesung;
		this.frage = frage;
	}

	public ProzentTyp getBewertung() {
		return bewertung;
	}

	public void bewerteLoesung() {
		this.bewertung = frage.bewerteLoesung(this);
	}

	public IFrage getFrage() {
		return frage;
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
