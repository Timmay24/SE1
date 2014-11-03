package edu.haw.se1.sole.modulverwaltung;

import edu.haw.se1.sole.common.IPersistenceService;

public class Modulverwaltung implements IModulverwaltung {

	private IPersistenceService persistenceService;

	public Modulverwaltung(IPersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}
}
