package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.modulverwaltung.IModul;

public class FrageFreitext extends FrageBase {

	public FrageFreitext(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException
	{
		super(fragestellung, modul, schwierigkeit, musterLoesung);
		this.musterLoesung = musterLoesung; //TIM: muss die hier noch?
        // in FrageBase haben wir schon this.setMusterLoesung(musterLoesung);
		// das w�rde durch den super() Aufruf abgefr�hst�ckt werden.
	}
}
