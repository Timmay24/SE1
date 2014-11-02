package edu.haw.se1.sole.benutzerverwaltung;

public enum NutzerrollenTyp {
	
	DOZENT(1),
	STUDENT(2);
	
	private int id;

	private NutzerrollenTyp(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
