package edu.haw.se1.sole;

import edu.haw.se1.sole.belohnungssystem.Belohnungssystem;
import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.benutzerverwaltung.Benutzerverwaltung;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzerverwaltung;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.common.PersistenceServiceStub;
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
	private IPersistenceService persistenceService;

	public DependencyAssembler() {
		// TODO Auto-generated constructor stub
	}
	
	public void buildTestDependencies() {
		this.persistenceService = new PersistenceServiceStub();
		this.modulVerwaltung = new Modulverwaltung(persistenceService);
		this.fragenVerwaltung = new Fragenverwaltung(persistenceService, modulVerwaltung);
		this.sitzungsVerwaltung = new Sitzungsverwaltung(persistenceService, fragenVerwaltung, modulVerwaltung);
		this.belohnungsSystem = new Belohnungssystem(persistenceService);
		this.benutzerVerwaltung = new Benutzerverwaltung(persistenceService, sitzungsVerwaltung, fragenVerwaltung, belohnungsSystem);
		this.gruppenVerwaltung = new Gruppenverwaltung(persistenceService, modulVerwaltung, benutzerVerwaltung, belohnungsSystem);
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
