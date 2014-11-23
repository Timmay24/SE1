package edu.haw.se1.sole.fragenverwaltung.frage.musterloesung;

import java.util.List;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;
import edu.haw.se1.sole.fragenverwaltung.frage.loesung.FragenloesungMultipleChoice;

public class MusterloesungMultipleChoice extends MusterloesungBase implements IMusterloesung {

	public MusterloesungMultipleChoice(List<Antwort> loesung) {
		super(loesung);
	}

	/**
	 * Für MC ist vorgesehen, dass es mindestens zwei Antwortmöglichkeiten
	 * und mindestens eine richtige Antwort geben muss.
	 * 
	 * @return true, falls Bedingungen erfüllt, false, wenn nicht.
	 */
	@Override
	public boolean invariant() {
		if (loesung != null)
		{
			if (loesung.size() > 1)
			{
				if (getAnzahlKorrekterAntworten() > 0)
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return Anzahl als korrekt markierte Antwortmöglichkeiten.
	 */
	private int getAnzahlKorrekterAntworten() {
		int korrekteAntworten = 0;
		for (Antwort a : loesung)
		{
			if (a.isKorrekteAntwort())
				korrekteAntworten++;
		}
		return korrekteAntworten;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IMusterloesung#bewerteLoesung(edu.haw.se1.sole.fragenverwaltung.IFragenloesung)
	 */
	@Override
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung) {
		if (fragenLoesung != null)
		{
			if (fragenLoesung instanceof FragenloesungMultipleChoice)
			{
				return new ProzentTyp(100);
			}
		}
		return new ProzentTyp(0);
	}

}
