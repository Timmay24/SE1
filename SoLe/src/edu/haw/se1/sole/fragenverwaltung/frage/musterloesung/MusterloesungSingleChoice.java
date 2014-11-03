package edu.haw.se1.sole.fragenverwaltung.frage.musterloesung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;

public class MusterloesungSingleChoice extends MusterloesungBase {

	public MusterloesungSingleChoice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProzentTyp rateLoesung(IFragenloesung fragenLoesung) {
		// TODO Auto-generated method stub
		return new ProzentTyp(0);
	}

}
