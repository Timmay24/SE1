package edu.haw.se1.sole.fragenverwaltung;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.haw.se1.sole.DependencyAssembler;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class FrageMultipleChoiceTest {

	private DependencyAssembler da;
    private IFragenverwaltung fragenVerwaltung;
    private IModulverwaltung modulVerwaltung;

    @Before
    public void setUp() {
        da = new DependencyAssembler();
		da.buildTestDependencies();
		fragenVerwaltung = da.getFragenVerwaltung();
		modulVerwaltung = da.getModulVerwaltung();
    }
    
    @Test
	public void testFrageMultipleChoiceWithCorrectInputIsValid() throws InvalidFrageException {
		List<Antwort> antworten = Arrays.asList(
				fragenVerwaltung.antwort("1", false),
				fragenVerwaltung.antwort("2", false),
				fragenVerwaltung.antwort("3", true),
				fragenVerwaltung.antwort("4", false));
		
		IMusterloesung musterloesung = fragenVerwaltung.createMusterloesungMultipleChoice(antworten);
		fragenVerwaltung.createFrageMultipleChoice("Is das gut?", modulVerwaltung.createModul("Mocking", "SE1"), new SchwierigkeitsgradTyp(1), musterloesung);
	}
    
    @Test(expected = InvalidFrageException.class)
    public void testFrageMultipleChoiceWithWrongFragestellungThrowsException() throws InvalidFrageException {
    	List<Antwort> antworten = Arrays.asList(
				fragenVerwaltung.antwort("1", false),
				fragenVerwaltung.antwort("2", false),
				fragenVerwaltung.antwort("3", true),
				fragenVerwaltung.antwort("4", false));
    	
    	IMusterloesung musterloesung = fragenVerwaltung.createMusterloesungMultipleChoice(antworten);
    	
    	fragenVerwaltung.createFrageMultipleChoice("", modulVerwaltung.createModul("Mocking", "SE1"), new SchwierigkeitsgradTyp(1), musterloesung);
    }
    
    @Test(expected = InvalidFrageException.class)
    public void testFrageMultipleChoiceWithWrongModulThrowsException() throws InvalidFrageException {
    	List<Antwort> antworten = Arrays.asList(
				fragenVerwaltung.antwort("1", false),
				fragenVerwaltung.antwort("2", false),
				fragenVerwaltung.antwort("3", true),
				fragenVerwaltung.antwort("4", false));
    	
    	IMusterloesung musterloesung = fragenVerwaltung.createMusterloesungMultipleChoice(antworten);
    	
    	fragenVerwaltung.createFrageMultipleChoice("passt", null, new SchwierigkeitsgradTyp(1), musterloesung);
    }
    
    @Test(expected = InvalidFrageException.class)
    public void testFrageMultipleChoiceWithWrongSchwierigkeitsgradThrowsException() throws InvalidFrageException {
    	List<Antwort> antworten = Arrays.asList(
				fragenVerwaltung.antwort("1", false),
				fragenVerwaltung.antwort("2", false),
				fragenVerwaltung.antwort("3", true),
				fragenVerwaltung.antwort("4", false));
    	
    	IMusterloesung musterloesung = fragenVerwaltung.createMusterloesungMultipleChoice(antworten);
    	
    	fragenVerwaltung.createFrageMultipleChoice("", modulVerwaltung.createModul("Mocking", "SE1"), null, musterloesung);
    }
    
    @Test(expected = InvalidFrageException.class)
    public void testFrageMultipleChoiceWithWrongMusterloesungThrowsException() throws InvalidFrageException {
    	List<Antwort> antworten = Arrays.asList(
				fragenVerwaltung.antwort("1", false),
				fragenVerwaltung.antwort("2", false),
				fragenVerwaltung.antwort("3", true),
				fragenVerwaltung.antwort("4", false));
    	
    	IMusterloesung musterloesung = fragenVerwaltung.createMusterloesungMultipleChoice(antworten);
    	
    	fragenVerwaltung.createFrageMultipleChoice("", modulVerwaltung.createModul("Mocking", "SE1"), new SchwierigkeitsgradTyp(1), null);
    }

}
