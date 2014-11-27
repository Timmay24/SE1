package edu.haw.se1.sole.gruppenverwaltung;

import java.util.Set;

import edu.haw.se1.sole.belohnungssystem.IBadge;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzer;
import edu.haw.se1.sole.modulverwaltung.IModul;

public interface ILerngruppe {

	/**
	 * @return true if group is empty, false if not.
	 */
	public abstract boolean isEmpty();

	/**
	 * @param modul sets new module to group
	 */
	public abstract void changeModule(IModul modul);

	/**
	 * @param benutzer
	 * @return true if benutzer was added
	 */
	public abstract boolean addMitglied(IBenutzer benutzer);
	
	public abstract boolean removeMitglied(IBenutzer benutzer);

	/**
	 * @param benutzer
	 * @return true, if benutzer is member of the group
	 */
	public abstract boolean containsBenutzer(IBenutzer benutzer);

	/**
	 * @return the mitglieder
	 */
	public abstract Set<IBenutzer> getMitglieder();
	
	/**
	 * @return count of mitglieder
	 */
	public default int getAnzahlMitglieder() {
		return getMitglieder().size();
	}

	/**
	 * @return the badges
	 */
	public abstract Set<IBadge> getBadges();

	/**
	 * @return the modul
	 */
	public abstract IModul getModul();

	/**
	 * @return the zutrittscode
	 */
	public abstract String getZutrittscode();

	/**
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * @return true, if passcode is required to join group
	 */
	public abstract boolean requiresZutrittscode();

	/**
	 * @param other
	 * @return
	 */
	public abstract boolean sameMembersAsIn(ILerngruppe other);

}