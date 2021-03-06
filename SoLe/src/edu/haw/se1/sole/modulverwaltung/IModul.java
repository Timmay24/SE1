package edu.haw.se1.sole.modulverwaltung;

public interface IModul {

	/**
	 * @return the bezeichnung
	 */
	public abstract String getBezeichnung();

	/**
	 * @return the studiengang
	 */
	public abstract String getStudiengang();

	/**
	 * @return the schule
	 */
	public abstract String getSchule();
	
	public abstract int getModulId();

}