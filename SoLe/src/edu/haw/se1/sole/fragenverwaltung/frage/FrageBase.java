package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungBase;
import edu.haw.se1.sole.modulverwaltung.Modul;

public abstract class FrageBase implements IFrage {

	protected MusterloesungBase musterLoesung;
	private Modul modul;

	protected FrageBase(String fragestellung, Modul modul) {
		this.modul = modul;
		this.setMusterLoesung(musterLoesung);
	}

	public MusterloesungBase getMusterLoesung() {
		return musterLoesung;
	}

	private void setMusterLoesung(MusterloesungBase musterLoesung) {
		this.musterLoesung = musterLoesung;
	}

	public Modul getModul() {
		return modul;
	}

	public void setModul(Modul modul) {
		this.modul = modul;
	}
	
}