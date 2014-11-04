package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungMultipleChoice;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class FrageMultipleChoice extends FrageBase {

	public FrageMultipleChoice(String fragestellung, Modul modul, SchwierigkeitsgradTyp schwierigkeit, MusterloesungMultipleChoice musterLoesung) {
		super(fragestellung, modul, schwierigkeit);
		this.musterLoesung = musterLoesung;
	}

	@Override
	public ProzentTyp rateLoesung(IFragenloesung fragenLoesung) {
		// TODO Auto-generated method stub
		return this.musterLoesung.rateLoesung(fragenLoesung);
	}

}
