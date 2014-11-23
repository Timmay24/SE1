package edu.haw.se1.sole.fragenverwaltung.frage.musterloesung;

import java.util.List;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;


public class MusterloesungSingleChoice extends MusterloesungBase implements IMusterloesung {


	protected MusterloesungSingleChoice(List<Antwort> loesung) {
		super(loesung);
	}

	@Override
	public boolean invariant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung) {
		// TODO Auto-generated method stub
		return new ProzentTyp(100); //MOCK
	}

}
