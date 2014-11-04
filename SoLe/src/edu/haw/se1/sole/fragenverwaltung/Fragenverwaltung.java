package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageSingleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungSingleChoice;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class Fragenverwaltung implements IFragenverwaltung {

	private IModulverwaltung modulVerwaltung;
	private IPersistenceService persistenceService;

	public Fragenverwaltung(IPersistenceService persistenceService, IModulverwaltung modulVerwaltung) {
		this.persistenceService = persistenceService;
		this.modulVerwaltung = modulVerwaltung;
	}
	
	public IFrage buildFrageSingleChoice(String fragestellung, Modul modul, SchwierigkeitsgradTyp schwierigkeit, MusterloesungSingleChoice musterLoesung) {
		return new FrageSingleChoice(fragestellung, modul, schwierigkeit, musterLoesung);
	}

}
