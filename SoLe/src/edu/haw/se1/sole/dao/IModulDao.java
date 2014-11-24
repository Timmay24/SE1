package edu.haw.se1.sole.dao;

import java.util.List;

import edu.haw.se1.sole.modulverwaltung.IModul;

public interface IModulDao {
    
    public IModul getModulBy(int id);
    
    public List<IModul> getAllModules();
    
    public IModul saveModul(IModul modul);

}
