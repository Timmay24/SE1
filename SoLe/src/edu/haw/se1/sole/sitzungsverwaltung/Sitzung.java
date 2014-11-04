package edu.haw.se1.sole.sitzungsverwaltung;

import java.util.Map;

import edu.haw.se1.sole.fragenverwaltung.IFrage;

public class Sitzung {
	
	private Map<Integer, IFrage> sitzungsFragen;

	public Sitzung(Map<Integer, IFrage> sitzungsFragen) {
		this.sitzungsFragen = sitzungsFragen;
	}
	
	public IFrage getFrage(int id) {
		return sitzungsFragen.get(id);
	}
}