package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.modulverwaltung.IModul;

public abstract class FrageBase implements IFrage {

	private String fragestellung;
	private IModul modul;
	private SchwierigkeitsgradTyp schwierigkeit;
	protected IMusterloesung musterLoesung;
    private int frage_id;
	
	/**
	 * @param fragestellung
	 * @param modul
	 * @param schwierigkeit
	 * @throws InvalidFrageException
	 */
	protected FrageBase(int frage_id, String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException {
		this.frage_id = frage_id;
        this.setFragestellung(fragestellung);
		this.setModul(modul);
		this.setSchwierigkeitsgrad(schwierigkeit);
		this.setMusterLoesung(musterLoesung);
		
		invariant();
	}
	
	/**
	 * @return true, wenn Invariante der Instanz nicht verletzt wird
	 * @throws InvalidFrageException 
	 */
	private void invariant() throws InvalidFrageException
	{
		InvalidFrageException e = new InvalidFrageException(this);
		
		if (getFragestellung() == null || getFragestellung().isEmpty())
			e.addInvalidField("fragestellung");
		if (getModul() == null)
			e.addInvalidField("modul");
		if (getSchwierigkeitsgrad() == null)
			e.addInvalidField("schwierigkeit");
		if (getMusterLoesung() == null)
			e.addInvalidField("musterloesung");
		
		if (e.hasInvalidFields())
			throw e;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFrage#getMusterLoesung()
	 */
	public IMusterloesung getMusterLoesung() {
		return musterLoesung;
	}

	private void setMusterLoesung(IMusterloesung musterLoesung) {
		this.musterLoesung = musterLoesung;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFrage#getModul()
	 */
	public IModul getModul() {
		return modul;
	}

	private void setModul(IModul modul) {
		this.modul = modul;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFrage#getFragestellung()
	 */
	public String getFragestellung() {
		return fragestellung;
	}

	public void setFragestellung(String fragestellung) {
		this.fragestellung = fragestellung;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFrage#getSchwierigkeitsgrad()
	 */
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad() {
		return schwierigkeit;
	}

	public void setSchwierigkeitsgrad(SchwierigkeitsgradTyp schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFrage#bewerteLoesung(edu.haw.se1.sole.fragenverwaltung.IFragenloesung)
	 */
	@Override
	public ProzentTyp bewerteLoesung(IFragenloesung fragenLoesung) {
		return this.musterLoesung.bewerteLoesung(fragenLoesung);
	}

    public int getFrageId() {
        return frage_id;
    }

    public void setFrageId(int frage_id) {
        this.frage_id = frage_id;
    }
	
}