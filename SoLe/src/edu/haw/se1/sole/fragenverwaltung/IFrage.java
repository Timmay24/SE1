package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.modulverwaltung.IModul;

public interface IFrage extends BadgeInteraction {
	
	/**
	 * @return Text der Fragestellung
	 */
	public String getFragestellung();
	
	/**
	 * @return Modul, zum dem die Frage zugeordnet wird.
	 */
	public IModul getModul();
	
	/**
	 * @return Musterloesung zur Frage, mit der eine Benutzerloesung verglichen
	 *         werden kann
	 */
	public IMusterloesung getMusterLoesung();
	
	/**
	 * @return Schwierigkeitsgrad der Frage
	 */
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();
	
	/**
	 * Vergleicht eine abgegebene Loesung mit der hinterlegten
	 * Musterloesung der Frage.
	 * 
	 * @param fragenLoesung Abgegebene Loesung. 
	 * @return Gibt die Bewertung der Loesung in Prozent zurueck
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);
	
	public int getFrageId();

}
