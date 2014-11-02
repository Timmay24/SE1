package edu.haw.se1.sole.benutzerverwaltung;


public class Benutzer {

	private String 			benutzerkennung;
	private String 			passwort;
	private EmailTyp		email;
	private String 			name;
	private String 			vorname;
	private String 			geburtsdatum;
	private NutzerrollenTyp	nutzerrolle;
	
	public Benutzer() {
		this.setBenutzerkennung("admin");
		this.setPasswort("password");
		this.setEmail("admin@sole.edu");
		this.setName("Darfes");
		this.setVorname("Admin");
		this.setGeburtsdatum("13.03.2007");
		this.setNutzerrolle(nutzerrolle);
	}
	
	

	public Benutzer(String benutzerkennung, String passwort, String email,
			String name, String vorname, String geburtsdatum,
			NutzerrollenTyp nutzerrolle) {
		
		this.setBenutzerkennung(benutzerkennung);
		this.setPasswort(passwort);
		this.setEmail(email);
		this.setName(name);
		this.setVorname(vorname);
		this.setGeburtsdatum(geburtsdatum);
		this.setNutzerrolle(nutzerrolle);
	}



	/**
	 * @return the benutzerkennung
	 */
	public String getBenutzerkennung() {
		return benutzerkennung;
	}

	/**
	 * @param benutzerkennung the benutzerkennung to set
	 */
	private void setBenutzerkennung(String benutzerkennung) {
		this.benutzerkennung = benutzerkennung;
	}

	/**
	 * @return the passwort
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * @param passwort the passwort to set
	 */
	private void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * @return the email
	 */
	public EmailTyp getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(EmailTyp email) {
		this.email = email;
	}
	
	public void setEmail(String email) {
		this.email = new EmailTyp(email);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	private void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the geburtsdatum
	 */
	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	/**
	 * @param geburtsdatum the geburtsdatum to set
	 */
	private void setGeburtsdatum(String geburtsdatum) {
		//TODO: Umbasteln, dass korrektes Datum erzeugt wird, statt dass jeder String genommen wird.
		this.geburtsdatum = geburtsdatum;
	}

	/**
	 * @return the nutzerrolle
	 */
	public NutzerrollenTyp getNutzerrolle() {
		return nutzerrolle;
	}

	/**
	 * @param nutzerrolle the nutzerrolle to set
	 */
	private void setNutzerrolle(NutzerrollenTyp nutzerrolle) {
		this.nutzerrolle = nutzerrolle;
	}
	
	

}
