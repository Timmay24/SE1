package edu.haw.se1.sole.belohnungssystem;

public class Badge {
	
	private String name;
	private String beschreibung;
	private String bildPfad;

	/**
	 * @param name
	 * @param beschreibung
	 * @param bildPfad
	 */
	public Badge(String name, String beschreibung, String bildPfad) {
		this.name = name;
		this.beschreibung = beschreibung;
		this.bildPfad = bildPfad;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * @return
	 */
	public String getBildPfad() {
		return bildPfad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Badge))
			return false;
		Badge other = (Badge) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}