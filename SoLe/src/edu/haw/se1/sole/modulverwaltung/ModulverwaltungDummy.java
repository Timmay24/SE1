package edu.haw.se1.sole.modulverwaltung;

import java.util.ArrayList;
import java.util.List;

import edu.haw.se1.sole.common.IPersistenceService;

public class ModulverwaltungDummy implements IModulverwaltung {

	private IPersistenceService persistenceService;
	
	// Liste vorerst als Ersatz fuer die DB Persistenz
	private List<IModul> module;

	public ModulverwaltungDummy(IPersistenceService persistenceService) {
		this.persistenceService = persistenceService;
		this.module = new ArrayList<>();
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#createModul(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public IModul createModul(String bezeichnung, String studiengang) {
		return new Modul(bezeichnung, studiengang);
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#getModulBy(java.lang.String)
	 */
	@Override
	public IModul getModulBy(int id) {
		// gemockt mit Liste statt DB Persistenz
		for (IModul m : getModule()) {
			if (m.getModulId() == id);
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
	public IModul saveModul(IModul modul)
	{
		//stub
		return modul;
	}
	
	
}
