package edu.haw.se1.sole;

import edu.haw.se1.sole.belohnungssystem.Belohnungssystem;
import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.benutzerverwaltung.Benutzerverwaltung;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzerverwaltung;
import edu.haw.se1.sole.fragenverwaltung.Fragenverwaltung;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.gruppenverwaltung.Gruppenverwaltung;
import edu.haw.se1.sole.gruppenverwaltung.IGruppenverwaltung;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;
import edu.haw.se1.sole.modulverwaltung.Modulverwaltung;
import edu.haw.se1.sole.sitzungsverwaltung.ISitzungsverwaltung;
import edu.haw.se1.sole.sitzungsverwaltung.Sitzungsverwaltung;

public class DependencyAssembler {
	
	private IModulverwaltung modulVerwaltung;
	private ISitzungsverwaltung sitzungsVerwaltung;
	private IFragenverwaltung fragenVerwaltung;
	private IBelohnungssystem belohnungsSystem;
	private IBenutzerverwaltung benutzerVerwaltung;
	private IGruppenverwaltung gruppenVerwaltung;

	public DependencyAssembler() {
		// TODO Auto-generated constructor stub
	}
	
	public void buildDepencies() {
		this.modulVerwaltung = new Modulverwaltung();
		this.fragenVerwaltung = new Fragenverwaltung(modulVerwaltung);
		this.sitzungsVerwaltung = new Sitzungsverwaltung(fragenVerwaltung, modulVerwaltung);
		this.belohnungsSystem = new Belohnungssystem();
		this.benutzerVerwaltung = new Benutzerverwaltung(sitzungsVerwaltung, fragenVerwaltung, belohnungsSystem);
		this.gruppenVerwaltung = new Gruppenverwaltung(modulVerwaltung, benutzerVerwaltung, belohnungsSystem);
	}

	public IModulverwaltung getModulVerwaltung() {
		return modulVerwaltung;
	}

	public ISitzungsverwaltung getSitzungsVerwaltung() {
		return sitzungsVerwaltung;
	}

	public IFragenverwaltung getFragenVerwaltung() {
		return fragenVerwaltung;
	}

	public IBelohnungssystem getBelohnungsSystem() {
		return belohnungsSystem;
	}

	public IBenutzerverwaltung getBenutzerVerwaltung() {
		return benutzerVerwaltung;
	}

	public IGruppenverwaltung getGruppenVerwaltung() {
		return gruppenVerwaltung;
	}

}
