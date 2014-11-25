package edu.haw.se1.sole;

import edu.haw.se1.sole.belohnungssystem.BelohnungssystemDummy;
import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.benutzerverwaltung.Benutzerverwaltung;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzerverwaltung;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.common.PersistenceService;
import edu.haw.se1.sole.common.PersistenceServiceStub;
import edu.haw.se1.sole.fragenverwaltung.Fragenverwaltung;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.gruppenverwaltung.Gruppenverwaltung;
import edu.haw.se1.sole.gruppenverwaltung.IGruppenverwaltung;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;
import edu.haw.se1.sole.modulverwaltung.Modulverwaltung;
import edu.haw.se1.sole.modulverwaltung.ModulverwaltungDummy;
import edu.haw.se1.sole.sitzungsverwaltung.ISitzungsverwaltung;
import edu.haw.se1.sole.sitzungsverwaltung.Sitzungsverwaltung;

public class DependencyAssembler {
	
	private IModulverwaltung modulVerwaltung;
	private IBelohnungssystem belohnungsSystem;
	private IBenutzerverwaltung benutzerVerwaltung;
	private IFragenverwaltung fragenVerwaltung;
	private ISitzungsverwaltung sitzungsVerwaltung;
	private IGruppenverwaltung gruppenVerwaltung;
	private IPersistenceService persistenceService;

	/**
	 * Der DependencyAssembler dient zur Erzeugung aller nötigen
	 * Komponenteninstanzen und injiziert Referenzen.
	 */
	public DependencyAssembler() {}
	

    /**
	 * Erzeugt Komponenteninstanzen und injiziert Referenzen
	 */
	public void buildTestDependencies() {
		resetDependencies();
		persistenceService = new PersistenceServiceStub();
		modulVerwaltung = new ModulverwaltungDummy(persistenceService);
		belohnungsSystem = new BelohnungssystemDummy(persistenceService);
		benutzerVerwaltung = new Benutzerverwaltung(persistenceService, belohnungsSystem);
		fragenVerwaltung = new Fragenverwaltung(persistenceService, modulVerwaltung, benutzerVerwaltung, belohnungsSystem);
		sitzungsVerwaltung = new Sitzungsverwaltung(persistenceService, fragenVerwaltung, modulVerwaltung);
		gruppenVerwaltung = new Gruppenverwaltung(persistenceService, modulVerwaltung, benutzerVerwaltung, belohnungsSystem);
	}
	
	/**
	 * Setzt dependencies auf null, damit Fehler in der Reihenfolge von buildDependencies nicht auffallen.
	 */
	private void resetDependencies() {
		persistenceService = null;
		modulVerwaltung = null;
		belohnungsSystem = null;
		benutzerVerwaltung = null;
		fragenVerwaltung = null;
		sitzungsVerwaltung = null;
		gruppenVerwaltung = null;
	}


	public void buildDependencies(IPersistenceService persistenceService) {
		resetDependencies();
		
		this.persistenceService = persistenceService;
	    modulVerwaltung = new Modulverwaltung(persistenceService);
	    belohnungsSystem = new BelohnungssystemDummy(persistenceService);
	    benutzerVerwaltung = new Benutzerverwaltung(persistenceService, belohnungsSystem);
	    fragenVerwaltung = new Fragenverwaltung(persistenceService, modulVerwaltung, benutzerVerwaltung, belohnungsSystem);
	    sitzungsVerwaltung = new Sitzungsverwaltung(persistenceService, fragenVerwaltung, modulVerwaltung);
	    gruppenVerwaltung = new Gruppenverwaltung(persistenceService, modulVerwaltung, benutzerVerwaltung, belohnungsSystem);
	}

	/**
	 * @return Instanz der Modulverwaltung 
	 */
	public IModulverwaltung getModulVerwaltung() {
		return modulVerwaltung;
	}

	/**
	 * @return Instanz der Sitzungsverwaltung 
	 */
	public ISitzungsverwaltung getSitzungsVerwaltung() {
		return sitzungsVerwaltung;
	}

	/**
	 * @return Instanz der Fragenverwaltung 
	 */
	public IFragenverwaltung getFragenVerwaltung() {
		return fragenVerwaltung;
	}

	/**
	 * @return Instanz des Belohnungssystem
	 */
	public IBelohnungssystem getBelohnungsSystem() {
		return belohnungsSystem;
	}

	/**
	 * @return Instanz der Benutzerverwaltung 
	 */
	public IBenutzerverwaltung getBenutzerVerwaltung() {
		return benutzerVerwaltung;
	}

	/**
	 * @return Instanz der Gruppenverwaltung 
	 */
	public IGruppenverwaltung getGruppenVerwaltung() {
		return gruppenVerwaltung;
	}

}
