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
	 * @param fragenLoesung Zu bewertende L�sung. Wird mit der Musterl�sung verglichen.
	 * @return Angabe der Korrektheit der �bergebenen L�sung in Prozent.
	 */
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung);

}
