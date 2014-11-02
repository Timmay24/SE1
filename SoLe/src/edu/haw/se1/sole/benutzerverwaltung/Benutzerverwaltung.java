package edu.haw.se1.sole.benutzerverwaltung;

import edu.haw.se1.sole.IPersistenceServices;
import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.sitzungsverwaltung.ISitzungsverwaltung;

public class Benutzerverwaltung implements IBenutzerverwaltung, IPersistenceServices {

	private ISitzungsverwaltung sitzungsVerwaltung;
	private IFragenverwaltung fragenVerwaltung;
	private IBelohnungssystem belohnungsSystem;

	public Benutzerverwaltung(ISitzungsverwaltung sitzungsVerwaltung, IFragenverwaltung fragenVerwaltung, IBelohnungssystem belohnungsSystem) {
		this.sitzungsVerwaltung = sitzungsVerwaltung;
		this.fragenVerwaltung = fragenVerwaltung;
		this.belohnungsSystem = belohnungsSystem;
	}
}