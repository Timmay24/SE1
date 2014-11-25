package edu.haw.se1.sole.benutzerverwaltung;

import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.sitzungsverwaltung.ISitzungsverwaltung;

public class Benutzerverwaltung implements IBenutzerverwaltung {

	private IPersistenceService persistenceService;

	public Benutzerverwaltung(IPersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

    @Override
    public IBenutzer getCurrentUser() {
        // TODO implement
        return new Benutzer();
    }
}