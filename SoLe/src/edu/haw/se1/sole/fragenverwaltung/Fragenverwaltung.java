package edu.haw.se1.sole.fragenverwaltung;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.Assert;

import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzerverwaltung;
import edu.haw.se1.sole.common.IPersistenceService;
import edu.haw.se1.sole.dao.FrageDaoMultipleChoiceJDBC;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageBase;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageFreitext;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageMultipleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageSingleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.loesung.FragenloesungFreitext;
import edu.haw.se1.sole.fragenverwaltung.frage.loesung.FragenloesungMultipleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.loesung.FragenloesungSingleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungFreitext;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungMultipleChoice;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungSingleChoice;
import edu.haw.se1.sole.modulverwaltung.IModul;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;
import edu.haw.se1.sole.modulverwaltung.Modul;
import edu.haw.se1.sole.modulverwaltung.ModulverwaltungDummy;

public class Fragenverwaltung implements IFragenverwaltung {

	protected IModulverwaltung modulVerwaltung;
	protected IPersistenceService persistenceService;
	private FrageDaoMultipleChoiceJDBC frageDaoMultipleChoiceJDBC;
	private IBelohnungssystem belohnungsSystem;
	private IBenutzerverwaltung benutzerVerwaltung;

	/**
	 * @param persistenceService
	 * @param modulVerwaltung
	 */
	public Fragenverwaltung(IPersistenceService persistenceService, IModulverwaltung modulVerwaltung, IBenutzerverwaltung benutzerVerwaltung, IBelohnungssystem belohnungsSystem)
	{
		this.persistenceService = persistenceService;
		this.modulVerwaltung = modulVerwaltung;
		this.benutzerVerwaltung = benutzerVerwaltung;
		this.belohnungsSystem = belohnungsSystem;
		frageDaoMultipleChoiceJDBC = new FrageDaoMultipleChoiceJDBC(persistenceService.getDataSource());
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createFragenloesungFreitext(java.util.List, edu.haw.se1.sole.fragenverwaltung.IFrage)
	 */
	@Override
	public IFragenloesung createFragenloesungFreitext(List<Antwort> loesung, IFrage frage)
	{
		return new FragenloesungFreitext(loesung, frage);
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createFragenloesungSingleChoice(java.util.List, edu.haw.se1.sole.fragenverwaltung.IFrage)
	 */
	@Override
	public IFragenloesung createFragenloesungSingleChoice(List<Antwort> loesung, IFrage frage)
	{
		return new FragenloesungSingleChoice(loesung, frage);
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createFragenloesungMultipleChoice(java.util.List, edu.haw.se1.sole.fragenverwaltung.IFrage)
	 */
	@Override
	public IFragenloesung createFragenloesungMultipleChoice(List<Antwort> loesung, IFrage frage)
	{
		return new FragenloesungMultipleChoice(loesung, frage);
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createFrageFreitext(java.lang.String, edu.haw.se1.sole.modulverwaltung.IModul, edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp, edu.haw.se1.sole.fragenverwaltung.IMusterloesung)
	 */
	@Override
	public IFrage createFrageFreitext(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException
	{
		return new FrageFreitext( -1,
				"freitext",
				modul,
				new SchwierigkeitsgradTyp(5),
				new MusterloesungFreitext(Arrays.asList(createAntwort("die richtige antwort", true))));
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createFrageSingleChoice(java.lang.String, edu.haw.se1.sole.modulverwaltung.IModul, edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp, edu.haw.se1.sole.fragenverwaltung.IMusterloesung)
	 */
	@Override
	public IFrage createFrageSingleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException
	{
		return new FrageSingleChoice(-1, fragestellung, modul, schwierigkeit, musterLoesung);
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createFrageMultipleChoice(java.lang.String, edu.haw.se1.sole.modulverwaltung.IModul, edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp, edu.haw.se1.sole.fragenverwaltung.IMusterloesung)
	 */
	@Override
	public IFrage createFrageMultipleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException
	{
		//TODO NULL POINTER ABFANGEN
		return new FrageMultipleChoice(-1, fragestellung, modul, schwierigkeit, musterLoesung);
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createMusterloesungFreitext()
	 */
	@Override
	public MusterloesungFreitext createMusterloesungFreitext()
	{
		//TODO: implement
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createMusterloesungSingleChoice(java.util.List)
	 */
	@Override
	public MusterloesungSingleChoice createMusterloesungSingleChoice(List<Antwort> antworten)
	{
		//TODO: implement
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#createMusterloesungMultipleChoice(java.util.List)
	 */
	@Override
	public MusterloesungMultipleChoice createMusterloesungMultipleChoice(List<Antwort> antworten)
	{
		Assert.notNull(antworten);
		Assert.notEmpty(antworten);
		return new MusterloesungMultipleChoice(antworten);
	}
	
	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#saveFrage(edu.haw.se1.sole.fragenverwaltung.IFrage)
	 */
	@Override
	public InteractionResult<IFrage> saveFrage(IFrage frage)
	{
		// TODO return badge with frage
	    if (frage instanceof FrageMultipleChoice) {
	        return new InteractionResult<>(frageDaoMultipleChoiceJDBC.saveFrage((FrageMultipleChoice) frage),
	        belohnungsSystem.updateBadgesFor(benutzerVerwaltung.getCurrentUser()));
	    }
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung#antwort(java.lang.String, boolean)
	 */
	@Override
	public Antwort createAntwort(String antwort, boolean korrekt) {
		return new Antwort(antwort, korrekt);
	}
}
