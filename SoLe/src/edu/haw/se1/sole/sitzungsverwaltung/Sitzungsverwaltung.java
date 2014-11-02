package edu.haw.se1.sole.sitzungsverwaltung;

import edu.haw.se1.sole.IPersistenceServices;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class Sitzungsverwaltung implements ISitzungsverwaltung, IPersistenceServices {

	private IFragenverwaltung fragenVerwaltung;
	private IModulverwaltung modulVerwaltung;

	public Sitzungsverwaltung(IFragenverwaltung fragenVerwaltung, IModulverwaltung modulVerwaltung) {
		this.fragenVerwaltung = fragenVerwaltung;
		this.modulVerwaltung = modulVerwaltung;
	}
}