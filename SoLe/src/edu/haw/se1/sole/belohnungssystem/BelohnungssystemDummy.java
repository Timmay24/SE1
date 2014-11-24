package edu.haw.se1.sole.belohnungssystem;

import java.util.ArrayList;
import java.util.List;

import edu.haw.se1.sole.benutzerverwaltung.IBenutzer;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.gruppenverwaltung.ILerngruppe;

public class BelohnungssystemDummy implements IBelohnungssystem {
	
	private IPersistenceService persistenceService;

	/**
	 * Das Belohnungssystem verwaltet Badges und prüft nach Nutzer-Interaktionen
	 * mit dem System, ob Benutzer oder Lerngruppen neue Badges verdienen und
	 * fügt ihren Profilen ggf. neue Badges hinzu.
	 * 
	 * @param persistenceService
	 */
	public BelohnungssystemDummy(IPersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBelohnungssystem#createBadge()
	 */
	@Override
	public IBadge createBadge() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBelohnungssystem#getBadges()
	 */
	@Override
	public List<IBadge> getBadges() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBelohnungssystem#getBadgeBy(java.lang.String)
	 */
	@Override
	public IBadge getBadgeBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBelohnungssystem#saveBadge(edu.haw.se1.sole.belohnungssystem.IBadge)
	 */
	@Override
	public IBadge saveBadge(IBadge badge) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBelohnungssystem#updateBadgesFor(edu.haw.se1.sole.benutzerverwaltung.IBenutzer)
	 */
	@Override
	public List<IBadge> updateBadgesFor(IBenutzer benutzer) {
	    return new ArrayList<IBadge>();
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBelohnungssystem#updateBadgesFor(edu.haw.se1.sole.gruppenverwaltung.ILerngruppe)
	 */
	@Override
	public List<IBadge> updateBadgesFor(ILerngruppe lerngruppe) {
        return new ArrayList<IBadge>();
	}
	
}
