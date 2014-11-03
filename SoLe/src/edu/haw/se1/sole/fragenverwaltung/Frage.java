package edu.haw.se1.sole.fragenverwaltung;

public class Frage {

	private FrageTyp typ;
	private Musterloesung musterLoesung;

	public Frage(FrageTyp typ, String fragestellung, Musterloesung musterLoesung) {
		this.setTyp(typ);
		this.setMusterLoesung(musterLoesung);
	}

	public FrageTyp getTyp() {
		return typ;
	}

	private void setTyp(FrageTyp typ) {
		this.typ = typ;
	}

	public Musterloesung getMusterLoesung() {
		return musterLoesung;
	}

	private void setMusterLoesung(Musterloesung musterLoesung) {
		this.musterLoesung = musterLoesung;
	}
}