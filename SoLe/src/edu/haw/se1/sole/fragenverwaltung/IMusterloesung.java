package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;

public interface IMusterloesung {

	/**
	 * Da es sich um eine Musterlösung handelt,
	 * liegt die Korrektheit grundsätzlich bei 100%.
	 * 
	 * @return Korrektheit der Lösung.
	 */
	public default ProzentTyp getKorrektheit() {
		return new ProzentTyp(100);
	}

	/**
	 * Vergleicht die übergebene Lösung mit sich und drückt die Korrektheit der Lösung in Prozent aus.
	 * 
	 * @param fragenLoesung Zu bewertende Lösung
	 * @return Angabe der Korrektheit der übergebenen Lösung in Prozent
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);

}
