package edu.haw.se1.sole.sitzungsverwaltung;

import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class Sitzungsverwaltung implements ISitzungsverwaltung, IPersistenceService {

	private IFragenverwaltung fragenVerwaltung;
	private IModulverwaltung modulVerwaltung;

	public Sitzungsverwaltung(IFragenverwaltung fragenVerwaltung, IModulverwaltung modulVerwaltung) {
		this.fragenVerwaltung = fragenVerwaltung;
		this.modulVerwaltung = modulVerwaltung;
	}
}