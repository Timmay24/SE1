package edu.haw.se1.sole.fragenverwaltung;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.haw.se1.sole.DependencyAssembler;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class FrageMultipleChoiceTest {

	@Test
	public void testCreateFrageMultipleChoice() {
		
		DependencyAssembler da = new DependencyAssembler();
		da.buildTestDependencies();
		IFragenverwaltung fv = da.getFragenVerwaltung();
		IModulverwaltung mv = da.getModulVerwaltung();
		
		List<Antwort> antworten = Arrays.asList(
				fv.antwort("1", false),
				fv.antwort("2", false),
				fv.antwort("3", true),
				fv.antwort("4", false));
		
		IMusterloesung musterloesung = fv.createMusterloesungMultipleChoice(antworten);
		
		// Erstellung der Frage
		IFrage frage = fv.createFrageMultipleChoice("Is das gut?", mv.mockModul(), new SchwierigkeitsgradTyp(1), musterloesung);
		
		// Validierung der Frage
		assertTrue(fv.validateFrage(frage));
		
		// Aufforderung zur Sicherung in der DB, wenn Validierung erfolgreich
		assertTrue(fv.saveFrage(frage));
		
		
	}

}
