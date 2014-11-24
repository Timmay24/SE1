package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.modulverwaltung.IModul;

public class FrageMultipleChoice extends FrageBase {

	public FrageMultipleChoice(int frage_id, String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) {
		super(frage_id, fragestellung, modul, schwierigkeit, musterLoesung);
		this.musterLoesung = musterLoesung;
	}

}
