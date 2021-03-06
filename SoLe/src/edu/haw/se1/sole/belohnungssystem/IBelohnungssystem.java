package edu.haw.se1.sole.belohnungssystem;

import java.util.List;

import edu.haw.se1.sole.benutzerverwaltung.IBenutzer;
import edu.haw.se1.sole.gruppenverwaltung.ILerngruppe;

public interface IBelohnungssystem {
	
	/**
	 * Erzeugt eine neue Badge.
	 * 
	 * @return Erzeugte Badge.
	 */
	public IBadge createBadge(); //TODO: params are missing
	
	/**
	 * @return Alle verfuegbaren Badges.
	 */
	public List<IBadge> getBadges();
	
	/**
	 * Erzeugt eine Instanz mit allen Daten der gesuchten Badge.
	 * 
	 * @param name Name der gesuchten Badge.
	 * @return Badge mit dem Namen name
	 */
	public IBadge getBadgeBy(String name);
	
	/**
	 * Veranlasst die Speicherung der Daten eines Badgeobjekts in der Persistenz.
	 * 
	 * @param badge Badge, die gespeichert werden soll
	 * @return Eine neue, zu badge gleichwertige, Instanz mit korrekter ID aus der Persistenz
	 */
	public IBadge saveBadge(IBadge badge);
	
	/**
	 * Routine zur Pruefung, ob der Benutzer eine neue Badge verdient hat.
	 * 
	 * @param benutzer Zu ueberpruefender Benutzer
	 */
	public List<IBadge> updateBadgesFor(IBenutzer benutzer);
	
	/**
	 * Routine zur Pruefung, ob die Lerngruppe eine neue Badge verdient hat.
	 * 
	 * @param lerngruppe Zu ueberpruefende Lerngruppe
	 */
	public List<IBadge> updateBadgesFor(ILerngruppe lerngruppe);

}
