package edu.haw.se1.sole.fragenverwaltung.frage;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.IFragenloesung;
import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;
import edu.haw.se1.sole.modulverwaltung.IModul;
import edu.haw.se1.sole.modulverwaltung.Modul;

public abstract class FrageBase implements IFrage {

	private String fragestellung;
	private IModul modul;
	private SchwierigkeitsgradTyp schwierigkeit;
	protected IMusterloesung musterLoesung;
	
	/**
	 * @param fragestellung
	 * @param modul
	 * @param schwierigkeit
	 */
	protected FrageBase(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit) {
		this.setFragestellung(fragestellung);
		this.modul = modul;
		this.setSchwierigkeitsgrad(schwierigkeit);
		this.setMusterLoesung(musterLoesung); //TODO: Woher kommt die musterLoesung bzw. die initiale Belegung??
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFrage#validateFrage()
	 */
	public boolean validateFrage()
	{
		return invariant();
	}
	
	/**
	 * @return true, wenn Invariante der Instanz nicht verletzt wird
	 */
	private boolean invariant()
	{
		if (this.getFragestellung() != null)
		if (!this.getFragestellung().isEmpty())
		if (this.getMusterLoesung() != null)
		if (this.getSchwierigkeitsgrad() != null)
			return true;
		
		return false;
	}

	/**
	 * @return Liefert die hinterlegte Musterloesung
	 */
	public IMusterloesung getMusterLoesung() {
		return musterLoesung;
	}

	private void setMusterLoesung(IMusterloesung musterLoesung) {
		this.musterLoesung = musterLoesung;
	}

	/**
	 * @return Liefert das zugeordnete Modul
	 */
	public IModul getModul() {
		return modul;
	}

	public void setModul(Modul modul) {
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
	
}