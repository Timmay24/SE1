package edu.haw.se1.sole.modulverwaltung;

import java.util.List;

public interface IModulverwaltung {

	/**
	 * Erstellt ein Modul.
	 * Module werden verwendet, um Fragen oder Lerngruppen thematisch einzuordnen.
	 * 
	 * @param bezeichnung Stichpunkt, der kurz das Themengebiet benennt.
	 * @param studiengang Studiengang, zu dem ein Modul zugeordnet werden kann.
	 * 	 	  Module / Themen koennen, je nach Studiengang, unterschiedlich behandelt werden.
	 * @return
	 */
	public abstract IModul createModul(String bezeichnung, String studiengang);

    /**
	 * Gibt die Instanz eines gesuchten Moduls zurueck.
	 * 
	 * @param bezeichnung Name des gesuchten Moduls
	 * @return Instanz des gesuchten Moduls
	 */
	public abstract IModul getModulBy(int id);

	/**
	 * @return Gibt Instanzen aller verfuegbaren Module in einer Liste zurueck
	 */
	public abstract List<IModul> getModule();
	
    /**
	 * Veranlasst die Speicherung der Daten eines Modulobjekts in der Persistenz.
	 * 
	 * @param modul Modul, das gespeichert werden soll
	 * @return Eine neue, zu modul gleichwertige, Instanz mit korrekter ID aus der Persistenz
	 */
	public IModul saveModul(IModul modul);

}