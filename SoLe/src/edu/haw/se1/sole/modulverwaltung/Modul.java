package edu.haw.se1.sole.modulverwaltung;

public class Modul {

	private String 	bezeichnung;
	private String 	studiengang;
	private String 	schule;
	
	/**
	 * BASE CONSTRUCTOR
	 * 
	 * @param bezeichnung
	 * @param semester
	 * @param studiengang
	 * @param schule
	 */
	public Modul(String bezeichnung, String studiengang, String schule) {
		this.bezeichnung = bezeichnung;
		this.studiengang = studiengang;
		this.schule = schule;
	}
	
	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * @return the studiengang
	 */
	public String getStudiengang() {
		return studiengang;
	}
	/**
	 * @param studiengang the studiengang to set
	 */
	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}
	/**
	 * @return the schule
	 */
	public String getSchule() {
		return schule;
	}
	/**
	 * @param schule the schule to set
	 */
	public void setSchule(String schule) {
		this.schule = schule;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
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
		if (!(obj instanceof Modul))
			return false;
		Modul other = (Modul) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		return true;
	}

	
}
