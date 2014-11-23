package edu.haw.se1.sole.fragenverwaltung.frage;

public class SchwierigkeitsgradTyp {

	private int schwierigkeit;

	public SchwierigkeitsgradTyp(int schwierigkeit) {
		checkInvariant();
		this.schwierigkeit = schwierigkeit;
	}

	public int getSchwierigkeit() {
		return schwierigkeit;
	}
	
	private void checkInvariant() {
		if (0 > schwierigkeit || 10 < schwierigkeit) {
			throw new IllegalArgumentException("Die Schwierigkeit muss zwischen 1 und 10 liegen.");
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + schwierigkeit;
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
		if (!(obj instanceof SchwierigkeitsgradTyp))
			return false;
		SchwierigkeitsgradTyp other = (SchwierigkeitsgradTyp) obj;
		if (schwierigkeit != other.schwierigkeit)
			return false;
		return true;
	}
	
	
}