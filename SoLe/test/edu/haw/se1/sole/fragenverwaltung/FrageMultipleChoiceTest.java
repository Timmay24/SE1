package edu.haw.se1.sole.fragenverwaltung;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.haw.se1.sole.DependencyAssembler;
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
	public void testFrageMultipleChoiceWithCorrectInputIsValid() {
		List<Antwort> antworten = Arrays.asList(
				fragenVerwaltung.antwort("1", false),
				fragenVerwaltung.antwort("2", false),
				fragenVerwaltung.antwort("3", true),
				fragenVerwaltung.antwort("4", false));
		
		IMusterloesung musterloesung = fragenVerwaltung.createMusterloesungMultipleChoice(antworten);
		fragenVerwaltung.createFrageMultipleChoice("Is das gut?", modulVerwaltung.createModul("Mocking", "SE1"), new SchwierigkeitsgradTyp(1), musterloesung);
	}

}
