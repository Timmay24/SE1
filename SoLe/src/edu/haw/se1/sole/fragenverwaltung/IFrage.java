package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;

public interface IFrage {
	
	/**
	 * @return Fragestellung.
	 */
	public String getFragestellung();
	
	/**
	 * Vergleicht eine abgegebene L�sung mit der hinterlegten
	 * Musterl�sung der Frage.
	 * 
	 * @param fragenLoesung Abgegebene L�sung. 
	 * @return Gibt die Bewertung der L�sung in Prozent zur�ck
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);
	
	/**
	 * @return Schwierigkeitsgrad
	 */
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();
	
	public int getFrageId();

}
