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
	 * @return Musterlösung zur Frage, mit der eine Benutzerlösung verglichen
	 *         werden kann
	 */
	public IMusterloesung getMusterLoesung();
	
	/**
	 * @return Schwierigkeitsgrad der Frage
	 */
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();
	
	/**
	 * Vergleicht eine abgegebene Lösung mit der hinterlegten
	 * Musterlösung der Frage.
	 * 
	 * @param fragenLoesung Abgegebene Lösung. 
	 * @return Gibt die Bewertung der Lösung in Prozent zurück
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);
	
	public int getFrageId();

}
