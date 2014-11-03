package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageSingleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.Schwierigkeitsgrad;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungSingleChoice;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class Fragenverwaltung implements IFragenverwaltung, IPersistenceService {

	private IModulverwaltung modulVerwaltung;
	private IPersistenceService persistenceService;

	public Fragenverwaltung(IPersistenceService persistenceService, IModulverwaltung modulVerwaltung) {
		this.persistenceService = persistenceService;
		this.modulVerwaltung = modulVerwaltung;
	}
	
	public IFrage buildFrageSingleChoice(String fragestellung, Modul modul, Schwierigkeitsgrad schwierigkeit, MusterloesungSingleChoice musterLoesung) {
		return new FrageSingleChoice(fragestellung, modul, schwierigkeit, musterLoesung);
	}

}
