package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungSingleChoice;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class FrageSingleChoice extends FrageBase {

	public FrageSingleChoice(String fragestellung, Modul modul, MusterloesungSingleChoice musterLoesung) {
		super(fragestellung, modul);
		this.musterLoesung = musterLoesung;
	}

	@Override
	public ProzentTyp rateLoesung(IFragenloesung fragenLoesung) {
		// TODO Auto-generated method stub
		return this.musterLoesung.rateLoesung(fragenLoesung);
	}

}
