package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;

public interface IFrage {
	
	/**
	 * @return Fragestellung.
	 */
	public String getFragestellung();
	
	/**
	 * Prüft die Invariante der Instanz
	 * 
	 * @return true, falls die Werte, mit denen die Frage erzeugt wurde,
	 * korrekt sind.
	 */
	public boolean validate();
	
	/**
	 * Vergleicht eine abgegebene Lösung mit der hinterlegten
	 * Musterlösung der Frage.
	 * 
	 * @param fragenLoesung Abgegebene Lösung. 
	 * @return Gibt die Bewertung der Lösung in Prozent zurück
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);
	
	/**
	 * @return Schwierigkeitsgrad
	 */
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();

}
