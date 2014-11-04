package edu.haw.se1.sole.gruppenverwaltung;

import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzerverwaltung;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class Gruppenverwaltung implements IGruppenverwaltung {

	private IModulverwaltung modulVerwaltung;
	private IBenutzerverwaltung benutzerVerwaltung;
	private IBelohnungssystem belohnungsSystem;
	private IPersistenceService persistenceService;

	public Gruppenverwaltung(IPersistenceService persistenceService, IModulverwaltung modulVerwaltung,
								IBenutzerverwaltung benutzerVerwaltung, IBelohnungssystem belohnungsSystem) {
		this.persistenceService = persistenceService;
		this.modulVerwaltung = modulVerwaltung;
		this.benutzerVerwaltung = benutzerVerwaltung;
		this.belohnungsSystem = belohnungsSystem;
	}
}
