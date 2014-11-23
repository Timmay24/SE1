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
	public IBadge createBadge();
	
	/**
	 * @return Alle verfügbaren Badges.
	 */
	public List<IBadge> getBadges();
	
	/**
	 * @param name Name der gesuchten Badge.
	 * @return Badge mit dem Namen name
	 */
	public IBadge getBadgeBy(String name);
	
	/**
	 * @param badge Badge, die in der DB gesichert werden soll.
	 * @return true, falls Sicherung erfolgreich.
	 */
	public boolean saveBadge(IBadge badge);
	
	/**
	 * Routine zur Prüfung, ob der Benutzer eine neue Badge verdient hat.
	 * 
	 * @param benutzer Zu überprüfender Benutzer
	 */
	public void updateBadgesFor(IBenutzer benutzer);
	
	/**
	 * Routine zur Prüfung, ob die Lerngruppe eine neue Badge verdient hat.
	 * 
	 * @param lerngruppe Zu überprüfende Lerngruppe
	 */
	public void updateBadgesFor(ILerngruppe lerngruppe);
}
