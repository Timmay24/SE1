package edu.haw.se1.sole.modulverwaltung;

import java.util.List;

public interface IModulverwaltung {

	public abstract IModul createModul(String bezeichnung, String studiengang,
			String schule);

	public abstract IModul mockModul();

	public abstract IModul getModulBy(String bezeichnung);

	public abstract List<IModul> getModule();

}