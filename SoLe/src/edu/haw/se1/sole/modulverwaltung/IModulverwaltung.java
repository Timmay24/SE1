package edu.haw.se1.sole.modulverwaltung;

import java.util.List;

public interface IModulverwaltung {

	/**
	 * Erstellt ein Modul.
	 * Module werden verwendet, um Fragen oder Lerngruppen thematisch einzuordnen.
	 * 
	 * @param bezeichnung Stichpunkt, der kurz das Themengebiet benennt.
	 * @param studiengang Studiengang, zu dem ein Modul zugeordnet werden kann.
	 * 	 	  Module / Themen k�nnen, je nach Studiengang, unterschiedlich behandelt werden.
	 * @return
	 */
	public abstract IModul createModul(String bezeichnung, String studiengang);

	/**
	 * Gibt die Instanz eines gesuchten Moduls zur�ck.
	 * 
	 * @param bezeichnung Name des gesuchten Moduls
	 * @return Instanz des gesuchten Moduls
	 */
	public abstract IModul getModulBy(String bezeichnung);

	/**
	 * @return Gibt Instanzen aller verf�gbaren Module in einer Liste zur�ck
	 */
	public abstract List<IModul> getModule();
	
	/**
	 * Veranlasst die Speicherung der Daten eines Moduls in der Persistenz.
	 * 
	 * @param modul Modul, das gespeichert werden soll
	 * @return true, wenn Speicherung erfolgreich
	 */
	public boolean saveModul(IModul modul);

}