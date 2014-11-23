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
	 * @return Alle verf�gbaren Badges.
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
	 * Routine zur Pr�fung, ob der Benutzer eine neue Badge verdient hat.
	 * 
	 * @param benutzer Zu �berpr�fender Benutzer
	 */
	public void updateBadgesFor(IBenutzer benutzer);
	
	/**
	 * Routine zur Pr�fung, ob die Lerngruppe eine neue Badge verdient hat.
	 * 
	 * @param lerngruppe Zu �berpr�fende Lerngruppe
	 */
	public void updateBadgesFor(ILerngruppe lerngruppe);
}
