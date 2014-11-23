package edu.haw.se1.sole.modulverwaltung;

public class Modul implements IModul {

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
	
	
	/** OPERATIONS */
	
	public boolean validateModul() {
		return invariant();
	}
	
	private boolean invariant() {
		if (this.bezeichnung != null)
		if (!this.bezeichnung.isEmpty())
		if (this.studiengang != null)
		if (!this.studiengang.isEmpty())
		if (this.schule != null)
		if (!this.schule.isEmpty())
			return true;
		
		return false;
	}
	
	
	/** GETTER */
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModul#getBezeichnung()
	 */
	@Override
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModul#getStudiengang()
	 */
	@Override
	public String getStudiengang() {
		return studiengang;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.modulverwaltung.IModul#getSchule()
	 */
	@Override
	public String getSchule() {
		return schule;
	}
	
	
	/** SETTER */
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	
	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}
	
	public void setSchule(String schule) {
		this.schule = schule;
	}

	

	/** COMPARISON */
	
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
