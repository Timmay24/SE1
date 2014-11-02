package edu.haw.se1.sole.belohnungssystem;

public class Badge {
	
	private String name;
	private String beschreibung;
	private String bildPfad;

	public Badge(String name, String beschreibung, String bildPfad) {
		this.setName(name);
		this.setBeschreibung(beschreibung);
		this.setBildPfad(bildPfad);
	}

	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}

	private void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getBildPfad() {
		return bildPfad;
	}

	private void setBildPfad(String bildPfad) {
		this.bildPfad = bildPfad;
	}

	
	
}