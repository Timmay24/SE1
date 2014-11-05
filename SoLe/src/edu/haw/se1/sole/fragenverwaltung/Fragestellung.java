package edu.haw.se1.sole.fragenverwaltung;

public class Fragestellung {

	private String frageStellung;

	public Fragestellung(String frageStellung) {
		this.frageStellung = frageStellung;
	}

	public String getFrageStellung() {
		return frageStellung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((frageStellung == null) ? 0 : frageStellung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fragestellung other = (Fragestellung) obj;
		if (frageStellung == null) {
			if (other.frageStellung != null)
				return false;
		} else if (!frageStellung.equals(other.frageStellung))
			return false;
		return true;
	}

}
