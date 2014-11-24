package edu.haw.se1.sole.belohnungssystem;

public interface IBadge {

	/**
	 * @return Bezeichnung der Badge.
	 */
	public abstract String getName();

	/**
	 * @return Beschreibung der Badge bzw. wof�r die Badge verdient wird.
	 */
	public abstract String getBeschreibung();

	/**
	 * @return Pfad zum Bild, das f�r eine Badge in der GUI angezeigt werden soll.
	 */
	public abstract String getBildPfad();
	
}