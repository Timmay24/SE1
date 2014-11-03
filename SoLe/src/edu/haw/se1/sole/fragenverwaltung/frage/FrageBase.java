package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungBase;
import edu.haw.se1.sole.modulverwaltung.Modul;

public abstract class FrageBase implements IFrage {

	protected MusterloesungBase musterLoesung;
	private Modul modul;
	private Schwierigkeitsgrad schwierigkeit;
	private String fragestellung;

	protected FrageBase(String fragestellung, Modul modul, Schwierigkeitsgrad schwierigkeit) {
		this.setFragestellung(fragestellung);
		this.modul = modul;
		this.setSchwierigkeitsgrad(schwierigkeit);
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

	public String getFragestellung() {
		return fragestellung;
	}

	public void setFragestellung(String fragestellung) {
		this.fragestellung = fragestellung;
	}

	public Schwierigkeitsgrad getSchwierigkeitsgrad() {
		return schwierigkeit;
	}

	public void setSchwierigkeitsgrad(Schwierigkeitsgrad schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}
	
}