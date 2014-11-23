package edu.haw.se1.sole.fragenverwaltung;

public class Antwort {

	/**
	 * Strukturierter Datentyp, der eine mögliche Antwort darstellt,
	 * der innerhalb einer Musterlösung als richtige ode falsche Antwort
	 * markiert werden kann.
	 */
	
	private String antwort;
	private boolean korrekt;
    private int antwort_id;
    private int frage_id;
	
	public Antwort(int antwort_id, int frage_id, String antwort, boolean korrekt) {
		this.antwort_id = antwort_id;
        this.frage_id = frage_id;
        this.antwort = antwort;
		this.korrekt = korrekt;
		if (!invariant())
			throw new IllegalArgumentException();
	}
	
	public Antwort(String antwort, boolean korrekt) {
        	super();
            this.antwort = antwort;
            this.korrekt = korrekt;
    }

    private boolean invariant() {
		if (antwort != null && !antwort.isEmpty())
			return true;
		
		return false;
	}

	public String getAntwort() {
		return antwort;
	}
	
	public boolean isKorrekteAntwort() {
		return korrekt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antwort == null) ? 0 : antwort.hashCode());
		result = prime * result + (korrekt ? 1231 : 1237);
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
		if (!(obj instanceof Antwort))
			return false;
		Antwort other = (Antwort) obj;
		if (antwort == null) {
			if (other.antwort != null)
				return false;
		} else if (!antwort.equals(other.antwort))
			return false;
		if (korrekt != other.korrekt)
			return false;
		return true;
	}

    public int getAntwort_id() {
        return antwort_id;
    }

    public void setAntwort_id(int antwort_id) {
        this.antwort_id = antwort_id;
    }

    public int getFrage_id() {
        return frage_id;
    }

    public void setFrage_id(int frage_id) {
        this.frage_id = frage_id;
    }
	
}