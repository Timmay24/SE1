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
	// alle Werte gesetzt sind und die Loesung immutable
	
	/**
	 * Konstruktor
	 * 
	 * @param loesung
	 * @param frage
	 */
	protected FragenloesungBase(List<Antwort> loesung, IFrage frage) {
		this.loesung = loesung;
		this.frage = frage;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenloesung#getBewertung()
	 */
	public ProzentTyp getBewertung() {
		return bewertung;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenloesung#bewerteLoesung()
	 */
	public void bewerteLoesung() {
		this.bewertung = frage.bewerteLoesung(this);
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenloesung#getFrage()
	 */
	public IFrage getFrage() {
		return frage;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenloesung#getSchwierigkeitsgrad()
	 */
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad() {
		return frage.getSchwierigkeitsgrad();
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenloesung#getBearbeitungsDatum()
	 */
	public Date getBearbeitungsDatum() {
		return bearbeitungsDatum;
	}
	
	protected void setBearbeitungsDatum(Date datum) {
		this.bearbeitungsDatum = datum;
	}
}
