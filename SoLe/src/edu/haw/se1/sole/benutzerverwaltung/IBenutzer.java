package edu.haw.se1.sole.benutzerverwaltung;

public interface IBenutzer {

	/**
	 * @return the benutzerkennung
	 */
	public abstract String getBenutzerkennung();

	/**
	 * @return the passwort
	 */
	public abstract String getPasswort();

	/**
	 * @return the email
	 */
	public abstract EMailTyp getEmail();

	/**
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * @return the vorname
	 */
	public abstract String getVorname();

	/**
	 * @return the geburtsdatum
	 */
	public abstract String getGeburtsdatum();

	/**
	 * @return the nutzerrolle
	 */
	public abstract NutzerrollenTyp getNutzerrolle();

}