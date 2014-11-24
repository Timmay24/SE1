package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;

public interface IMusterloesung {

	/**
	 * Da es sich um eine Musterl�sung handelt,
	 * liegt die Korrektheit grunds�tzlich bei 100%.
	 * 
	 * @return Korrektheit der L�sung.
	 */
	public default ProzentTyp getKorrektheit() {
		return new ProzentTyp(100);
	}

	/**
	 * Vergleicht die �bergebene L�sung mit sich und dr�ckt die Korrektheit der L�sung in Prozent aus.
	 * 
	 * @param fragenLoesung Zu bewertende L�sung
	 * @return Angabe der Korrektheit der �bergebenen L�sung in Prozent
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);

}
