package edu.haw.se1.sole.fragenverwaltung.exception;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.haw.se1.sole.DependencyAssembler;
import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.fragenverwaltung.IMusterloesung;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class FrageMultipleChoiceTest {

	private DependencyAssembler da;
    private IFragenverwaltung fragenVerwaltung;
    private IModulverwaltung modulVerwaltung;

    @Before
    public void setUp() {
        da = new DependencyAssembler();
		da.buildDependencies();
		fragenVerwaltung = da.getFragenVerwaltung();
		modulVerwaltung = da.getModulVerwaltung();
    }
    
    @Test
    public void testInvalidFrageExceptionDoesntContainErrors() throws InvalidFrageException {
    	List<Antwort> antworten = Arrays.asList(
				fragenVerwaltung.antwort("1", false),
				fragenVerwaltung.antwort("2", false),
				fragenVerwaltung.antwort("3", true),
				fragenVerwaltung.antwort("4", false));
    	
    	IMusterloesung musterloesung = fragenVerwaltung.createMusterloesungMultipleChoice(antworten);
    	
    	IFrage frage = fragenVerwaltung.createFrageMultipleChoice("haunse", modulVerwaltung.createModul("Mocking", "SE1"), new SchwierigkeitsgradTyp(1), musterloesung);
    	
    	InvalidFrageException e = new InvalidFrageException(frage);
    	
    	assertFalse(e.hasInvalidFields());
    }
    
    @Test
    public void testInvalidFrageExceptionInvalidFields() {
    	InvalidFrageException e = new InvalidFrageException(null);
    	e.addInvalidField("fragestellung");
    	assertTrue(e.isInvalid("fragestellung"));
    	assertTrue(e.hasInvalidFields());
    }

}
