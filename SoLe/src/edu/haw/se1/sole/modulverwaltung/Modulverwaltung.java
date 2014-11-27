package edu.haw.se1.sole.modulverwaltung;

import java.util.List;

import org.springframework.util.Assert;

import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.dao.ModulDaoJDBC;

public class Modulverwaltung implements IModulverwaltung {
    
    private IPersistenceService persistenceService;

    /**
     * @param persistenceService
     */
    public Modulverwaltung(IPersistenceService persistenceService) {
        super();
        this.persistenceService = persistenceService;
    }

    /* (non-Javadoc)
     * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#createModul(java.lang.String, java.lang.String)
     */
    @Override
    public IModul createModul(String bezeichnung, String studiengang) {
    	Assert.notNull(bezeichnung);
    	Assert.notNull(studiengang);
        // TODO Auto-generated method stub
        return new Modul(bezeichnung, studiengang);
    }

    /* (non-Javadoc)
     * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#getModulBy(int)
     */
    @Override
    public IModul getModulBy(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#getModule()
     */
    @Override
    public List<IModul> getModule() {
        return new ModulDaoJDBC(persistenceService.getDataSource()).getAllModules();
    }

    /* (non-Javadoc)
     * @see edu.haw.se1.sole.modulverwaltung.IModulverwaltung#saveModul(edu.haw.se1.sole.modulverwaltung.IModul)
     */
    @Override
    public IModul saveModul(IModul modul) {
    	Assert.notNull(modul);
        return new ModulDaoJDBC(persistenceService.getDataSource()).saveModul(modul);
    }

}
