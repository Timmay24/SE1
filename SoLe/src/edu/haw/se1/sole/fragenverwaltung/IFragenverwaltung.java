package edu.haw.se1.sole.fragenverwaltung;

import java.util.List;

import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.modulverwaltung.IModul;

public interface IFragenverwaltung {

	/** FREITEXT */

	/**
	 * @param fragestellung
	 * @param modul
	 * @param schwierigkeit
	 * @param musterLoesung
	 * @return Instanz einer neuen Frage
	 */
	public IFrage createFrageFreitext(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung);
	
	/**
	 * @param loesung
	 * @param frage
	 * @return Lösung zu einer Frage
	 */
	public IFragenloesung createFragenloesungFreitext(List<Antwort> loesung, IFrage frage);

	/**
	 * @return Musterlösung zu einer Frage
	 */
	public IMusterloesung createMusterloesungFreitext();

	
	/** SINGLE CHOICE */

	/**
	 * @param fragestellung
	 * @param modul
	 * @param schwierigkeit
	 * @param musterLoesung
	 * @return
	 */
	public IFrage createFrageSingleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung);
	
	/**
	 * @param loesung
	 * @param frage
	 * @return
	 */
	public IFragenloesung createFragenloesungSingleChoice(List<Antwort> loesung, IFrage frage);

	/**
	 * @param antworten
	 * @return
	 */
	public IMusterloesung createMusterloesungSingleChoice(List<Antwort> antworten);

	
	/** MULTIPLE CHOICE */

	/**
	 * @param fragestellung
	 * @param modul
	 * @param schwierigkeit
	 * @param musterLoesung
	 * @return
	 */
	public IFrage createFrageMultipleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung);
	
	/**
	 * @param loesung
	 * @param frage
	 * @return
	 */
	public IFragenloesung createFragenloesungMultipleChoice(List<Antwort> loesung, IFrage frage);

	/**
	 * @param loesung
	 * @return
	 */
	public IMusterloesung createMusterloesungMultipleChoice(List<Antwort> loesung);

	
	/** COMMON OPERATIONS */
	
	/**
	 * @param antwort Antwortmöglichkeit
	 * @param korrekt Kennzeichnung, ob richtige, oder falsche Antwort
	 * @return Antwort mit Kennzeichnung zur Korrektheit
	 */
	public Antwort antwort(String antwort, boolean korrekt);
	
	/**
	 * @param frage Frage, die in der DB gespeichert werden soll
	 * @return true, wenn Speicherung erfolgreich
	 */
	public IFrage saveFrage(IFrage frage);

}
