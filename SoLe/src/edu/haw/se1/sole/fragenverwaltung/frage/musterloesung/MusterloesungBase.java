package edu.haw.se1.sole.fragenverwaltung.frage.musterloesung;

import java.util.List;

import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;

public abstract class MusterloesungBase implements IMusterloesung {

	List<Antwort> loesung;
	
	protected MusterloesungBase(List<Antwort> loesung) {
		this.loesung = loesung;
		if (!invariant())
			throw new IllegalStateException();
	}
	
	/**
	 * @return true, wenn alle Werte, mit denen die Instanz erzeugt wurde,
	 * korrekt sind. false, falls nicht.
	 */
	protected abstract boolean invariant();
}
