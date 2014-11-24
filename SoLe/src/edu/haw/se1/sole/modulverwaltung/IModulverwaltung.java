package edu.haw.se1.sole.modulverwaltung;

import java.util.List;

public interface IModulverwaltung {

	public abstract IModul createModul(String bezeichnung, String studiengang); //TIM: is absofort geschissen auf String schule? :D

	public abstract IModul getModulBy(String bezeichnung);

	public abstract List<IModul> getModule();
	
	public boolean saveModul(IModul modul);

}