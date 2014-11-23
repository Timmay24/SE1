package edu.haw.se1.sole.belohnungssystem;

public class Badge implements IBadge {
	
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
		
		if (!invariant())
			throw new IllegalStateException();
	}
	
	@Override
	public boolean validate() {
		return invariant();
	}

	private boolean invariant() {
		if (this.beschreibung != null)
		if (!this.beschreibung.isEmpty())
		if (this.name != null)
		if (!this.name.isEmpty())
			return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBadge#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBadge#getBeschreibung()
	 */
	@Override
	public String getBeschreibung() {
		return beschreibung;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.belohnungssystem.IBadge#getBildPfad()
	 */
	@Override
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