package edu.haw.se1.sole.fragenverwaltung;

public class Frage {

	private FrageTyp typ;
	private Musterloesung musterLoesung;

	public Frage(FrageTyp typ, String fragestellung, Musterloesung musterLoesung) {
		this.typ = typ;
		this.musterLoesung = musterLoesung;
	}

	public FrageTyp getTyp() {
		return typ;
	}

	public void setTyp(FrageTyp typ) {
		this.typ = typ;
	}

	public Musterloesung getMusterLoesung() {
		return musterLoesung;
	}

	public void setMusterLoesung(Musterloesung musterLoesung) {
		this.musterLoesung = musterLoesung;
	}
}