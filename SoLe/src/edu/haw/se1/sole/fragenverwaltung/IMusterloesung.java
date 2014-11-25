package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;

public interface IMusterloesung {

	/**
	 * Da es sich um eine Musterloesung handelt,
	 * liegt die Korrektheit grundsaetzlich bei 100%.
	 * 
	 * @return Korrektheit der Loesung.
	 */
	public default ProzentTyp getKorrektheit() {
		return new ProzentTyp(100);
	}

	/**
	 * Vergleicht die uebergebene Loesung mit sich und drueckt die Korrektheit der Loesung in Prozent aus.
	 * 
	 * @param fragenLoesung Zu bewertende Loesung
	 * @return Angabe der Korrektheit der uebergebenen Loesung in Prozent
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);

}
