package edu.haw.se1.sole.fragenverwaltung;

import java.util.List;

import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.modulverwaltung.IModul;

public interface IFragenverwaltung {

	/** FREITEXT */

	/**
	 * Erzeugt eine Freitext-Frage.
	 * 
	 * @param fragestellung Textuelle Aufgabenstellung der Frage
	 * @param modul	Das Modul, dem die Frage zugeordnet sein soll
	 * @param schwierigkeit Schwierigkeitsgrad der Frage (1..10 | leicht..schwer)
	 * @param musterLoesung Musterloesung zur Frage, mit der spaeter eine abgegebene Loesung verglichen werden kann
	 * @return Instanz der neuen Freitext-Frage
	 * @throws InvalidFrageException
	 */
	public IFrage createFrageFreitext(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException;
	
	/**
	 * Erzeugt ein, zum Freitext-Fragen-Typ passendes, L�sungsobjekt.
	 * Wird erzeugt, um die Antwort(en) eines Benutzers zu verpacken, um einen
	 * Vergleich mit der Musterl�sung zu erm�glichen.
	 * 
	 * @param loesung Liste von Antwortm�glichkeiten (Markierung der korrekten Fragen ebenfalls enthalten)
	 * @param frage Frage zur die L�sung geh�rt
	 * @return Instanz der neuen L�sung
	 */
	public IFragenloesung createFragenloesungFreitext(List<Antwort> loesung, IFrage frage);

	/**
	 * @return Musterl�sung zu einer Freitext-Frage
	 */
	public IMusterloesung createMusterloesungFreitext();

	
	/** SINGLE CHOICE */

	/**
	 * Erzeugt eine Single-Choice-Frage.
	 * 
	 * @param fragestellung Textuelle Aufgabenstellung der Frage
	 * @param modul	Das Modul, dem die Frage zugeordnet sein soll
	 * @param schwierigkeit Schwierigkeitsgrad der Frage (1..10 | leicht..schwer)
	 * @param musterLoesung Musterloesung zur Frage, mit der spaeter eine abgegebene Loesung verglichen werden kann
	 * @return Instanz der neuen Single-CHoice--Frage
	 * @throws InvalidFrageException
	 */
	public IFrage createFrageSingleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException;
	
	/**
	 * Erzeugt ein, zum Single-Choice-Fragen-Typ passendes, L�sungsobjekt.
	 * Wird erzeugt, um die Antwort(en) eines Benutzers zu verpacken, um einen
	 * Vergleich mit der Musterl�sung zu erm�glichen.
	 * 
	 * @param loesung Liste von Antwortm�glichkeiten (Markierung der korrekten Fragen ebenfalls enthalten)
	 * @param frage Frage zur die L�sung geh�rt.
	 * @return Instanz der neuen L�sung
	 */
	public IFragenloesung createFragenloesungSingleChoice(List<Antwort> loesung, IFrage frage);

	/**
	 * @param antworten Liste von Antwortm�glichkeiten samt Markierung der korrekten Anwort
	 * @return Musterl�sung zu einer Freitext-Frage
	 */
	public IMusterloesung createMusterloesungSingleChoice(List<Antwort> antworten);

	
	/** MULTIPLE CHOICE */

	/**
	 * Erzeugt eine Multiple-Choice-Frage.
	 * 
	 * @param fragestellung Textuelle Aufgabenstellung der Frage
	 * @param modul	Das Modul, dem die Frage zugeordnet sein soll
	 * @param schwierigkeit Schwierigkeitsgrad der Frage (1..10 | leicht..schwer)
	 * @param musterLoesung Musterloesung zur Frage, mit der spaeter eine abgegebene Loesung verglichen werden kann
	 * @return Instanz der neuen Multiple-Choice-Frage
	 * @throws InvalidFrageException
	 */
	public IFrage createFrageMultipleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException;
	
	/**
	 * Erzeugt ein, zum Multiple-Choice-Fragen-Typ passendes, L�sungsobjekt.
	 * Wird erzeugt, um die Antwort(en) eines Benutzers zu verpacken, um einen
	 * Vergleich mit der Musterl�sung zu erm�glichen.
	 * 
	 * @param loesung Liste von Antwortm�glichkeiten (Markierung der korrekten Fragen ebenfalls enthalten)
	 * @param frage Frage zur die L�sung geh�rt.
	 * @return Instanz der neuen L�sung
	 */
	public IFragenloesung createFragenloesungMultipleChoice(List<Antwort> loesung, IFrage frage);

	/**
	 * @param antworten Liste von Antwortm�glichkeiten samt Markierung der korrekten Anworten
	 * @return Musterl�sung zu einer Freitext-Frage
	 */
	public IMusterloesung createMusterloesungMultipleChoice(List<Antwort> loesung);

	
	/** COMMON OPERATIONS */
	
	/**
	 * @param antwort Antwortm�glichkeit
	 * @param korrekt Kennzeichnung, ob richtige, oder falsche Antwort
	 * @return Antwort mit Kennzeichnung zur Korrektheit
	 */
	public Antwort antwort(String antwort, boolean korrekt);
	
	/**
	 * Veranlasst die Speicherung der Daten eines Frageobjekts in der Persistenz.
	 * 
	 * @param frage Frage, die gespeichert werden soll
	 * @return Eine neue, zu frage gleichwertige, Instanz mit korrekter ID aus der Persistenz
	 */
	public IFrage saveFrage(IFrage frage);

}
