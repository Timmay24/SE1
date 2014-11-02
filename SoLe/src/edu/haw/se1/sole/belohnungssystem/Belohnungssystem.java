package edu.haw.se1.sole.belohnungssystem;

import java.util.HashMap;
import java.util.Map;

import edu.haw.se1.sole.IPersistenceServices;

public class Belohnungssystem implements IBelohnungssystem, IPersistenceServices {
	
	private Map<String, Badge> badges;

	public Belohnungssystem() {
		this.badges = new HashMap<>();
	}
	
	public Badge createBadge(String name) {
		if (name == null) return null;
		
		Badge newBadge = new Badge(name, "beschreibungstext", "bildPfad");
		badges.put(name, newBadge);
		return newBadge;
	}
	
	public Badge getBadge(String name) {
		return badges.get(name); 
	}
	
	

}
