package edu.haw.se1.sole.fragenverwaltung;

public enum FrageTyp {
	
	SINGLECHOICE(1),
	MULTIPLECHOICE(2),
	FREITEXT(3);
	
	private int id;

	private FrageTyp(int id) {
		this.id = id;
	}

}
