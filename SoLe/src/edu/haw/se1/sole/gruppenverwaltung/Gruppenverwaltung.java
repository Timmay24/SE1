package edu.haw.se1.sole.gruppenverwaltung;

import edu.haw.se1.sole.IPersistenceServices;
import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzerverwaltung;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class Gruppenverwaltung implements IGruppenverwaltung, IPersistenceServices {

	private IModulverwaltung modulVerwaltung;
	private IBenutzerverwaltung benutzerVerwaltung;
	private IBelohnungssystem belohnungsSystem;

	public Gruppenverwaltung(IModulverwaltung modulVerwaltung, IBenutzerverwaltung benutzerVerwaltung, IBelohnungssystem belohnungsSystem) {
		this.modulVerwaltung = modulVerwaltung;
		this.benutzerVerwaltung = benutzerVerwaltung;
		this.belohnungsSystem = belohnungsSystem;
	}
}
