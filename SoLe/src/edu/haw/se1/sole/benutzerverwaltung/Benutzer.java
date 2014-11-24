package edu.haw.se1.sole.benutzerverwaltung;

public class Benutzer implements IBenutzer {

	private String 			benutzerkennung;
	private String 			passwort;
	private EMailTyp		email;
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
		
		setBenutzerkennung(benutzerkennung);
		setPasswort(passwort);
		setEmail(email);
		setName(name);
		setVorname(vorname);
		setGeburtsdatum(geburtsdatum);
		setNutzerrolle(nutzerrolle);
		
		if (!invariant())
			throw new IllegalStateException();
	}
	
	/**
	 * Shortcut to creating a sample user named 'admin'
	 */
	public Benutzer() {
		setBenutzerkennung("admin");
		setPasswort("password");
		setEmail("admin@sole.edu");
		setName("Darfes");
		setVorname("Admin");
		setGeburtsdatum("13.03.2000");
		setNutzerrolle(nutzerrolle);
		
		invariant();
	}
	
	private boolean invariant() {
		if (getBenutzerkennung() != null)
		if (!getBenutzerkennung().isEmpty())
		if (getPasswort() != null)
		if (!getPasswort().isEmpty())
//		if (!getPassword().size() > 5)
		if (getEmail() != null)
		if (getVorname() != null)
		if (!getVorname().isEmpty())
		if (getName() != null)
		if (!getName().isEmpty())
		if (getGeburtsdatum() != null)
		if (!getGeburtsdatum().isEmpty())
		if (getNutzerrolle() != null)
			return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.benutzerverwaltung.IBenutzer#getBenutzerkennung()
	 */
	@Override
	public String getBenutzerkennung() {
		return benutzerkennung;
	}
	
	private void setBenutzerkennung(String benutzerkennung) {
		this.benutzerkennung = benutzerkennung;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.benutzerverwaltung.IBenutzer#getPasswort()
	 */
	@Override
	public String getPasswort() {
		return passwort;
	}

	/**
	 * @param passwort the passwort to set
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.benutzerverwaltung.IBenutzer#getEmail()
	 */
	@Override
	public EMailTyp getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(EMailTyp email) {
		this.email = email;
	}
	
	public void setEmail(String email) {
		this.email = new EMailTyp(email);
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.benutzerverwaltung.IBenutzer#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.benutzerverwaltung.IBenutzer#getVorname()
	 */
	@Override
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.benutzerverwaltung.IBenutzer#getGeburtsdatum()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.benutzerverwaltung.IBenutzer#getNutzerrolle()
	 */
	@Override
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
