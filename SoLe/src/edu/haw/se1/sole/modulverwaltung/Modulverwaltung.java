package edu.haw.se1.sole.modulverwaltung;

import java.util.ArrayList;
import java.util.List;

import edu.haw.se1.sole.common.IPersistenceService;

public class Modulverwaltung implements IModulverwaltung {

	private IPersistenceService persistenceService;
	
	// Liste vorerst als Ersatz fuer die DB Persistenz
	private List<IModul> module;

	public Modulverwaltung(IPersistenceService persistenceService) {
		this.persistenceService = persistenceService;
		this.module = new ArrayList<>();
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#createModul(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public IModul createModul(String bezeichnung, String studiengang, String schule) {
		return new Modul(bezeichnung, studiengang, schule);
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#mockModul()
	 */
	@Override
	public IModul mockModul() {
		return createModul("Mocking", "SE1", "HAW");
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#getModulBy(java.lang.String)
	 */
	@Override
	public IModul getModulBy(String bezeichnung) {
		// gemockt mit Liste statt DB Persistenz
		for (IModul m : getModule()) {
			if (m.getBezeichnung().equals(bezeichnung));
				return m;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#getModule()
	 */
	@Override
	public List<IModul> getModule()
	{
		return module;
	}

	@Override
	public boolean validateModul(IModul modul)
	{
		return modul.validateModul();
	}

	@Override
	public boolean saveModul(IModul modul)
	{
		// MOCK
		return true;
	}
	
	
}
