package edu.haw.se1.sole.modulverwaltung;

import java.util.List;

import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.dao.ModulDaoJDBC;

public class Modulverwaltung implements IModulverwaltung {
    
    private IPersistenceService persistenceService;

    public Modulverwaltung(IPersistenceService persistenceService) {
        super();
        this.persistenceService = persistenceService;
    }

    @Override
    public IModul createModul(String bezeichnung, String studiengang) {
        // TODO Auto-generated method stub
        return new Modul(bezeichnung, studiengang);
    }

    @Override
    public IModul getModulBy(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<IModul> getModule() {
        return new ModulDaoJDBC(persistenceService.getDataSource()).getAllModules();
    }

    @Override
    public IModul saveModul(IModul modul) {
        // TODO Auto-generated method stub
        return new ModulDaoJDBC(persistenceService.getDataSource()).saveModul(modul);
    }

}
