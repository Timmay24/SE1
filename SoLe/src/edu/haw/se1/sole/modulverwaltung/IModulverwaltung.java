package edu.haw.se1.sole.modulverwaltung;

import java.util.List;

public interface IModulverwaltung {

	public abstract IModul createModul(String bezeichnung, String studiengang);

	public abstract IModul getModulBy(String bezeichnung);

	public abstract List<IModul> getModule();
	
	public abstract boolean validateModul(IModul modul);
	
	public boolean saveModul(IModul modul);

}