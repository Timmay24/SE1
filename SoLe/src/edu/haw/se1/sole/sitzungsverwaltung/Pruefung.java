package edu.haw.se1.sole.sitzungsverwaltung;

import java.util.Map;

import edu.haw.se1.sole.fragenverwaltung.IFrage;

public class Pruefung extends Sitzung {

	public Pruefung(Map<Integer, IFrage> pruefungsFragen) {
		super(pruefungsFragen);
	}
}
