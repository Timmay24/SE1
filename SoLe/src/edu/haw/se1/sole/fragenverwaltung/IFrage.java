package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.modulverwaltung.IModul;

public interface IFrage {
	
	/**
	 * @return Text der Fragestellung
	 */
	public String getFragestellung();
	
	/**
	 * @return Modul, zum dem die Frage zugeordnet wird.
	 */
	public IModul getModul();
	
	/**
	 * @return Musterl�sung zur Frage, mit der eine Benutzerl�sung verglichen
	 *         werden kann
	 */
	public IMusterloesung getMusterLoesung();
	
	/**
	 * @return Schwierigkeitsgrad der Frage
	 */
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();
	
	/**
	 * Vergleicht eine abgegebene L�sung mit der hinterlegten
	 * Musterl�sung der Frage.
	 * 
	 * @param fragenLoesung Abgegebene L�sung. 
	 * @return Gibt die Bewertung der L�sung in Prozent zur�ck
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);
	
	public int getFrageId();

}
