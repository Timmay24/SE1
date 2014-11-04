package edu.haw.se1.sole.benutzerverwaltung;

import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.sitzungsverwaltung.ISitzungsverwaltung;

public class Benutzerverwaltung implements IBenutzerverwaltung {

	private ISitzungsverwaltung sitzungsVerwaltung;
	private IFragenverwaltung fragenVerwaltung;
	private IBelohnungssystem belohnungsSystem;
	private IPersistenceService persistenceService;

	public Benutzerverwaltung(IPersistenceService persistenceService, ISitzungsverwaltung sitzungsVerwaltung, IFragenverwaltung fragenVerwaltung, IBelohnungssystem belohnungsSystem) {
		this.persistenceService = persistenceService;
		this.sitzungsVerwaltung = sitzungsVerwaltung;
		this.fragenVerwaltung = fragenVerwaltung;
		this.belohnungsSystem = belohnungsSystem;
	}
}