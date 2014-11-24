package edu.haw.se1.sole.belohnungssystem;

public interface IBadge {

	/**
	 * @return Bezeichnung der Badge.
	 */
	public abstract String getName();

	/**
	 * @return Beschreibung der Badge bzw. wofür die Badge verdient wird.
	 */
	public abstract String getBeschreibung();

	/**
	 * @return Pfad zum Bild, das für eine Badge in der GUI angezeigt werden soll.
	 */
	public abstract String getBildPfad();
	
}