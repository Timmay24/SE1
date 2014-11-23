package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungFreitext;
import edu.haw.se1.sole.modulverwaltung.IModul;

public class FrageFreitext extends FrageBase {

	public FrageFreitext(String fragestellung, IModul modul, MusterloesungFreitext musterLoesung, SchwierigkeitsgradTyp schwierigkeit)
	{
		super(fragestellung, modul, schwierigkeit, musterLoesung);
		this.musterLoesung = musterLoesung;
	}
}
