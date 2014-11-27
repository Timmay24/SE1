package edu.haw.se1.sole.gruppenverwaltung;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.Assert;

import edu.haw.se1.sole.belohnungssystem.Badge;
import edu.haw.se1.sole.belohnungssystem.IBadge;
import edu.haw.se1.sole.benutzerverwaltung.Benutzer;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzer;
import edu.haw.se1.sole.modulverwaltung.IModul;

public class Lerngruppe implements ILerngruppe {
	
	// simulating storage for relating data
	private String name;
	private Set<IBenutzer> mitglieder;
	private Set<IBadge> badges;
	private IModul modul;
	private String zutrittscode;

	/**
	 * BASE CONSTRUCTOR
	 * 
	 * @param modul
	 */
	public Lerngruppe(String name, IModul modul, String zutrittscode) {
		setName(name);
		setModul(modul);
		setZutrittscode(zutrittscode);
		setMitglieder(new HashSet<IBenutzer>());
		setBadges(new HashSet<IBadge>());
	}
	
	/**
	 * CONTRUCTOR FOR GROUP WITH NO PASSCODE
	 * 
	 * @param modul
	 */
	public Lerngruppe(String name, IModul modul) {
		this(name, modul, "");
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return mitglieder.isEmpty();
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#changeModule(edu.haw.se1.sole.modulverwaltung.Modul)
	 */
	@Override
	public void changeModule(IModul modul) {
		this.setModul(modul);
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#addMiglied(edu.haw.se1.sole.benutzerverwaltung.Benutzer)
	 */
	@Override
	public boolean addMitglied(IBenutzer benutzer) {
		Assert.notNull(benutzer);
		return getMitglieder().add(benutzer);
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#containsMember(edu.haw.se1.sole.benutzerverwaltung.IBenutzer)
	 */
	@Override
	public boolean containsBenutzer(IBenutzer benutzer) {
		if (benutzer != null) {
			return getMitglieder().contains(benutzer);
		} else {
			return false;
		}
	}
	
	// ACCESSORS //
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#getMitglieder()
	 */
	@Override
	public Set<IBenutzer> getMitglieder() {
		return mitglieder;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#getBadges()
	 */
	@Override
	public Set<IBadge> getBadges() {
		return badges;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#getModul()
	 */
	@Override
	public IModul getModul() {
		return modul;
	}

	/**
	 * @param modul the modul to set
	 */
	private void setModul(IModul modul) {
		this.modul = modul;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#getZutrittscode()
	 */
	@Override
	public String getZutrittscode() {
		return zutrittscode;
	}

	/**
	 * @param zutrittscode the zutrittscode to set
	 */
	private void setZutrittscode(String zutrittscode) {
		this.zutrittscode = zutrittscode;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#getName()
	 */
	@Override
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
	private void setMitglieder(Set<IBenutzer> mitglieder) {
		this.mitglieder = mitglieder;
	}

	/**
	 * @param badges the badges to set
	 */
	private void setBadges(Set<IBadge> badges) {
		this.badges = badges;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#requiresPasscode()
	 */
	@Override
	public boolean requiresZutrittscode() {
		return !getZutrittscode().isEmpty();
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.gruppenverwaltung.ILerngruppe#membersMatch(edu.haw.se1.sole.gruppenverwaltung.ILerngruppe)
	 */
	@Override
	public boolean sameMembersAsIn(ILerngruppe other) {
		if (other != null) {
			if (this.getAnzahlMitglieder() == other.getAnzahlMitglieder()) {
				return this.getMitglieder().containsAll(other.getMitglieder());
			}
		}
		return false;
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
		if (!(obj instanceof ILerngruppe))
			return false;
		ILerngruppe other = (ILerngruppe) obj;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}

	@Override
	public boolean removeMitglied(IBenutzer benutzer) {
		Assert.notNull(benutzer);
		return getMitglieder().remove(benutzer);
	}
}
