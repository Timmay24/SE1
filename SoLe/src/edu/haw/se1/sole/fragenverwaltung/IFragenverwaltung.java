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
	 * @throws InvalidFrageException, falls das Frageobjekt mit ungueltigen Werten erzeugt und damit die Invariante verletzt wird
	 */
	public IFrage createFrageFreitext(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException;
	
	/**
	 * Erzeugt ein, zum Freitext-Fragen-Typ passendes, Loesungsobjekt.
	 * Wird erzeugt, um die Antwort(en) eines Benutzers zu verpacken, um einen
	 * Vergleich mit der Musterloesung zu ermoeglichen.
	 * 
	 * @param antworten Liste von Antwortmoeglichkeiten (Markierung der korrekten Fragen ebenfalls enthalten)
	 * @param frage Frage zur die Loesung gehoert
	 * @return Instanz der neuen Loesung
	 */
	public IFragenloesung createFragenloesungFreitext(List<Antwort> antworten, IFrage frage);

	/**
	 * @return Musterloesung zu einer Freitext-Frage
	 */
	public IMusterloesung createMusterloesungFreitext();

	
	/** SINGLE CHOICE */

	/**
	 * Erzeugt eine Single-Choice-Frage.
	 * 
	 * @param fragestellung Textuelle Aufgabenstellung der Frage
	 * @param modul	Das Modul, dem die Frage zugeordnet sein soll
	 * @param schwierigkeitsgradDerFrage Schwierigkeitsgrad der Frage
	 * @param musterLoesung Musterloesung zur Frage, mit der spaeter eine abgegebene Loesung verglichen werden kann
	 * @return Instanz der neuen Single-CHoice-Frage
	 * @throws InvalidFrageException, falls das Frageobjekt mit ungueltigen Werten erzeugt und damit die Invariante verletzt wird
	 */
	public IFrage createFrageSingleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeitsgradDerFrage, IMusterloesung musterLoesung) throws InvalidFrageException;
	
	/**
	 * Erzeugt ein, zum Single-Choice-Fragen-Typ passendes, Loesungsobjekt.
	 * Wird erzeugt, um die Antwort(en) eines Benutzers zu verpacken, um einen
	 * Vergleich mit der Musterloesung zu ermoeglichen.
	 * 
	 * @param antworten Liste von Antwortmoeglichkeiten (Markierung der korrekten Fragen ebenfalls enthalten)
	 * @param frage Frage zur die Loesung gehoert.
	 * @return Instanz der neuen Loesung
	 * //TODO @pre
	 */
	public IFragenloesung createFragenloesungSingleChoice(List<Antwort> antworten, IFrage frage);

	/**
	 * @param antworten Liste von Antwortmoeglichkeiten samt Markierung der korrekten Anwort
	 * @return Musterloesung zu einer Freitext-Frage
	 */
	public IMusterloesung createMusterloesungSingleChoice(List<Antwort> antworten);

	
	/** MULTIPLE CHOICE */

	/**
	 * Erzeugt eine Multiple-Choice-Frage.
	 * 
	 * @param fragestellung Textuelle Aufgabenstellung der Frage
	 * @param modul	Das Modul, dem die Frage zugeordnet sein soll
	 * @param schwierigkeitgradDerFrage
	 * @param musterLoesung Musterloesung zur Frage, mit der spaeter eine abgegebene Loesung verglichen werden kann
	 * @return Instanz der neuen Multiple-Choice-Frage
	 * @throws InvalidFrageException, falls das Frageobjekt mit ungueltigen Werten erzeugt und damit die Invariante verletzt wird
	 * @pre {@code Assert.notNull(fragestellung)}
	 * @pre {@code Assert.notNull(modul)}
	 * @pre {@code Assert.notNull(schwierigkeit)}
	 * @pre {@code Assert.notNull(musterLoesung)}
	 * 
	 */
	public IFrage createFrageMultipleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeitgradDerFrage, IMusterloesung musterLoesung) throws InvalidFrageException;
	
	/**
	 * Erzeugt ein, zum Multiple-Choice-Fragen-Typ passendes, Loesungsobjekt.
	 * Wird erzeugt, um die Antwort(en) eines Benutzers zu verpacken, um einen
	 * Vergleich mit der Musterloesung zu ermoeglichen.
	 * 
	 * @param antworten Liste von Antwortmoeglichkeiten (Markierung der korrekten Fragen ebenfalls enthalten)
	 * @param frage Frage zur die Loesung gehoert.
	 * @return Instanz der neuen Loesung
	 * @pre {@code Assert.notNull(antworten)}
	 * @pre {@code Assert.notEmpty(antworten)}
	 * @pre {@code Assert.notNull(frage)}
	 */
	public IFragenloesung createFragenloesungMultipleChoice(List<Antwort> antworten, IFrage frage);

	/**
	 * Erzeugt ein, zum Multiple-Choice-Fragen-Typ passendes, Musterloesungsobjekt.
	 * Enthaelt die Antwortmoeglichkeiten samt Markierung der korrekten Antworten zu einer Frage
	 * Antworten eines Benutzers werden mit einer Musterloesung verglichen,
	 * um die Loesung eines Benutzers bewerten zu koennen.
	 * 
	 * @param antworten Liste von Antwortmoeglichkeiten, samt Markierung der korrekten Antworten
	 * @return Musterloesung zu einer Multiple-Choice-Frage
	 * @pre {@code Assert.notNull(antworten)}
	 * @pre {@code Assert.notEmpty(antworten)}
	 */
	public IMusterloesung createMusterloesungMultipleChoice(List<Antwort> antworten);

	
	/** COMMON OPERATIONS */
	
	/**
	 * @param antwort Antwortmoeglichkeit
	 * @param korrekt Kennzeichnung, ob richtige, oder falsche Antwort
	 * @return Antwort mit Kennzeichnung, ob sie korrekt ist
	 * 		   (nur relevant bei Verwendung als Antwort in einer Musterloesung)
	 * @pre {@code Assert.notNull(antwort)}
	 * @pre {@code Assert.notEmpty(antwort)}
	 */
	public Antwort createAntwort(String antwort, boolean korrekt);
	
	/**
	 * Veranlasst die Speicherung der Daten eines Frageobjekts in der Persistenz.
	 * 
	 * @param frage Frage, die gespeichert werden soll
	 * @return Ein Objekt, das eine wertegleiche Instanz der gespeicherten Frage (bis auf die, durch die Persistenz aktualisierte ID)
	 * 		   und eine Liste von, ggf. durch diese Aktion, verdienten Badges enthaelt
	 * @pre {@code Assert.notNull(frage)}
	 */
	public InteractionResult<IFrage> saveFrage(IFrage frage);

}
