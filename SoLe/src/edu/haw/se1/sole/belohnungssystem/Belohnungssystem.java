package edu.haw.se1.sole.belohnungssystem;

import java.util.List;

import edu.haw.se1.sole.benutzerverwaltung.IBenutzer;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.gruppenverwaltung.ILerngruppe;

public class Belohnungssystem implements IBelohnungssystem {
	
	private IPersistenceService persistenceService;

	public Belohnungssystem(IPersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	@Override
	public IBadge createBadge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IBadge> getBadges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBadge getBadgeBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveBadge(IBadge badge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateBadgesFor(IBenutzer benutzer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBadgesFor(ILerngruppe lerngruppe) {
		// TODO Auto-generated method stub
		
	}
	
}
