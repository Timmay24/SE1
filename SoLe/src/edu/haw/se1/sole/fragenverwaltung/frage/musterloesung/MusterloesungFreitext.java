package edu.haw.se1.sole.fragenverwaltung.frage.musterloesung;

import java.util.List;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;

public class MusterloesungFreitext extends MusterloesungBase {

	public MusterloesungFreitext(List<Antwort> loesung) {
		super(loesung);
	}

	@Override
	public boolean invariant() {
		return !loesung.isEmpty();
	}

	@Override
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung) {
		return new ProzentTyp(100); // MOCK
	}

}
