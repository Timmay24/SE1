package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;

public interface IFrage {
	
	/**
	 * @return Fragestellung.
	 */
	public String getFragestellung();
	
	/**
	 * Pr�ft die Invariante der Instanz
	 * 
	 * @return true, falls die Werte, mit denen die Frage erzeugt wurde,
	 * korrekt sind.
	 */
	public boolean validate();
	
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

}
