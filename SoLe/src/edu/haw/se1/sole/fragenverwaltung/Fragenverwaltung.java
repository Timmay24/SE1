package edu.haw.se1.sole.fragenverwaltung;

import java.util.Arrays;
import java.util.List;

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

	public Fragenverwaltung(IPersistenceService persistenceService, IModulverwaltung modulVerwaltung)
	{
		this.persistenceService = persistenceService;
		this.modulVerwaltung = modulVerwaltung;
	}
	
	@Override
	public IFragenloesung createFragenloesungFreitext(List<Antwort> loesung, IFrage frage)
	{
		return new FragenloesungFreitext(loesung, frage);
	}

	@Override
	public IFragenloesung createFragenloesungSingleChoice(List<Antwort> loesung, IFrage frage)
	{
		return new FragenloesungSingleChoice(loesung, frage);
	}

	@Override
	public IFragenloesung createFragenloesungMultipleChoice(List<Antwort> loesung, IFrage frage)
	{
		return new FragenloesungMultipleChoice(loesung, frage);
	}
	
	@Override
	public IFrage createFrageFreitext(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException
	{
		return new FrageFreitext( -1,
				"freitext",
				modul,
				new SchwierigkeitsgradTyp(5),
				new MusterloesungFreitext(Arrays.asList(antwort("die richtige antwort", true))));
	}
	
	@Override
	public IFrage createFrageSingleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException
	{
		return new FrageSingleChoice(-1, fragestellung, modul, schwierigkeit, musterLoesung);
	}
	
	@Override
	public IFrage createFrageMultipleChoice(String fragestellung, IModul modul, SchwierigkeitsgradTyp schwierigkeit, IMusterloesung musterLoesung) throws InvalidFrageException
	{
		return new FrageMultipleChoice(-1, fragestellung, modul, schwierigkeit, musterLoesung);
	}

	@Override
	public MusterloesungFreitext createMusterloesungFreitext()
	{
		return null;
	}

	@Override
	public MusterloesungSingleChoice createMusterloesungSingleChoice(List<Antwort> antworten)
	{
		return null;
	}

	@Override
	public MusterloesungMultipleChoice createMusterloesungMultipleChoice(List<Antwort> antworten)
	{
		return new MusterloesungMultipleChoice(antworten);
	}
	
	@Override
	public IFrage saveFrage(IFrage frage)
	{
	    if (frage instanceof FrageMultipleChoice) {
	        return new FrageDaoMultipleChoiceJDBC(persistenceService.getDataSource()).saveFrage((FrageMultipleChoice) frage);
	    }
		return frage;
	}

	@Override
	public Antwort antwort(String antwort, boolean korrekt) {
		return new Antwort(antwort, korrekt);
	}
}
