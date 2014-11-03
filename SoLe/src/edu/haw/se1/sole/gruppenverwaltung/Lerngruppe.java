package edu.haw.se1.sole.gruppenverwaltung;

import java.util.HashSet;
import java.util.Set;

import edu.haw.se1.sole.belohnungssystem.Badge;
import edu.haw.se1.sole.benutzerverwaltung.Benutzer;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class Lerngruppe {
	
	// simulating storage for relating data
	private String name;
	private Set<Benutzer> mitglieder;
	private Set<Badge> badges;
	private Modul modul;
	private String zutrittscode;

	/**
	 * BASE CONSTRUCTOR
	 * 
	 * @param modul
	 */
	public Lerngruppe(String name, Modul modul, String zutrittscode) {
		setName(name);
		setModul(modul);
		setZutrittscode(zutrittscode);
		setMitglieder(new HashSet<Benutzer>());
		setBadges(new HashSet<Badge>());
	}
	
	/**
	 * CONTRUCTOR FOR GROUP WITH NO PASSCODE
	 * 
	 * @param modul
	 */
	public Lerngruppe(String name, Modul modul) {
		this(name, modul, "");
	}
	
	/**
	 * @return true if group is empty, false if not.
	 */
	public boolean isEmpty() {
		return mitglieder.isEmpty();
	}
	
	/**
	 * @param modul sets new module to group
	 */
	public void changeModule(Modul modul) {
		this.setModul(modul);
	}
	
	/**
	 * @param benutzer
	 * @return true if benutzer was added
	 */
	public boolean addMiglied(Benutzer benutzer) {
		return getMitglieder().add(benutzer);
	}
	
	/**
	 * @param benutzer
	 * @return true, if benutzer is member of the group
	 */
	public boolean containsMember(Benutzer benutzer) {
		if (benutzer != null) {
			return getMitglieder().contains(benutzer);
		} else {
			return false;
		}
	}
	
	// ACCESSORS //
	/**
	 * @return the mitglieder
	 */
	public Set<Benutzer> getMitglieder() {
		return mitglieder;
	}
	
	/**
	 * @return the badges
	 */
	public Set<Badge> getBadges() {
		return badges;
	}

	/**
	 * @return the modul
	 */
	public Modul getModul() {
		return modul;
	}

	/**
	 * @param modul the modul to set
	 */
	private void setModul(Modul modul) {
		this.modul = modul;
	}
	
	/**
	 * @return the zutrittscode
	 */
	public String getZutrittscode() {
		return zutrittscode;
	}

	/**
	 * @param zutrittscode the zutrittscode to set
	 */
	private void setZutrittscode(String zutrittscode) {
		this.zutrittscode = zutrittscode;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @param mitglieder the mitglieder to set
	 */
	private void setMitglieder(Set<Benutzer> mitglieder) {
		this.mitglieder = mitglieder;
	}

	/**
	 * @param badges the badges to set
	 */
	private void setBadges(Set<Badge> badges) {
		this.badges = badges;
	}

	/**
	 * @return true, if passcode is required to join group
	 */
	public boolean requiresPasscode() {
		return !getZutrittscode().isEmpty();
	}

	/**
	 * @param other
	 * @return
	 */
	public boolean membersMatch(Lerngruppe other) {
		if (this.getMitglieder().size() == other.getMitglieder().size() &&
				this.getMitglieder().containsAll(other.getMitglieder())) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Lerngruppe))
			return false;
		Lerngruppe other = (Lerngruppe) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
