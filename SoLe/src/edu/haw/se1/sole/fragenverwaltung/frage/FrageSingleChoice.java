package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.modulverwaltung.IModul;

public class FrageSingleChoice extends FrageBase {

	public FrageSingleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException {
		super(fragestellung, modul, schwierigkeit, musterLoesung);
		this.musterLoesung = musterLoesung;
	}

}
