package edu.haw.se1.sole.benutzerverwaltung;

public class Benutzer {

	private String 			benutzerkennung;
	private String 			passwort;
	private EmailTyp		email;
	private String 			name;
	private String 			vorname;
	private String 			geburtsdatum;
//	private Date 			geburtsdatum;
	private NutzerrollenTyp	nutzerrolle;
	
	private final String	BDAY_STRING = "dd.MM.yyyy";
	
	
	/**
	 * BASE CONSTRUCTOR
	 * 
	 * @param benutzerkennung
	 * @param passwort
	 * @param email
	 * @param name
	 * @param vorname
	 * @param geburtsdatum
	 * @param nutzerrolle
	 */
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
	
	// Shortcut to creating a sample user
	public Benutzer() {
		this.setBenutzerkennung("admin");
		this.setPasswort("password");
		this.setEmail("admin@sole.edu");
		this.setName("Darfes");
		this.setVorname("Admin");
		this.setGeburtsdatum("13.03.2007");
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
	public void setPasswort(String passwort) {
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
	public void setName(String name) {
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
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the geburtsdatum
	 */
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	
	public void setGeburtsdatum(String datum) {
		this.geburtsdatum = datum;
	}
	
	// TODO: korrektes Datumsformat sicherstellen
//	/**
//	 * @param geburtsdatum the geburtsdatum to set
//	 */
//	private boolean setGeburtsdatum(String geburtsdatum) {
//		SimpleDateFormat sdf = new SimpleDateFormat(BDAY_STRING);
//		
//		try {
//			setGeburtsdatum(sdf.parse(geburtsdatum));
//			return true;
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
//	/**
//	 * @param geburtsdatum
//	 */
//	private void setGeburtsdatum(Date geburtsdatum) {
//		this.geburtsdatum = geburtsdatum;
//	}

	/**
	 * @return the nutzerrolle
	 */
	public NutzerrollenTyp getNutzerrolle() {
		return nutzerrolle;
	}

	/**
	 * @param nutzerrolle the nutzerrolle to set
	 */
	public void setNutzerrolle(NutzerrollenTyp nutzerrolle) {
		this.nutzerrolle = nutzerrolle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((benutzerkennung == null) ? 0 : benutzerkennung.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Benutzer))
			return false;
		Benutzer other = (Benutzer) obj;
		if (benutzerkennung == null) {
			if (other.benutzerkennung != null)
				return false;
		} else if (!benutzerkennung.equals(other.benutzerkennung))
			return false;
		return true;
	}

	
	
}
