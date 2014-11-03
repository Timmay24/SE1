package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.IPersistenceServices;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageSingleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.Schwierigkeitsgrad;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungSingleChoice;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class Fragenverwaltung implements IFragenverwaltung, IPersistenceServices {

	private IModulverwaltung modulVerwaltung;

	public Fragenverwaltung(IModulverwaltung modulVerwaltung) {
		this.modulVerwaltung = modulVerwaltung;
	}
	
	public IFrage buildFrageSingleChoice(String fragestellung, Modul modul, Schwierigkeitsgrad schwierigkeit, MusterloesungSingleChoice musterLoesung) {
		return new FrageSingleChoice(fragestellung, modul, schwierigkeit, musterLoesung);
	}

}
