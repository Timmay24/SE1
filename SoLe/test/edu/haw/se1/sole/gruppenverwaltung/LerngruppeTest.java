package edu.haw.se1.sole.gruppenverwaltung;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.haw.se1.sole.benutzerverwaltung.Benutzer;
import edu.haw.se1.sole.benutzerverwaltung.NutzerrollenTyp;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class LerngruppeTest {

	ILerngruppe g1;
	ILerngruppe g2;
	ILerngruppe g3;
	
	Benutzer u1;
	Benutzer u2;
	
	@Before
	public void setUp() {
		g1 = new Lerngruppe("g1", new Modul("mod1", "ai"));
		g2 = new Lerngruppe("g1", new Modul("mod1", "ai"));
		g3 = new Lerngruppe("g3", new Modul("mod3", "ai"));
		
		u1 = new Benutzer();
		u2 = new Benutzer("hacktim", "janeisklar", "tim.hartig@haw-hamburg.de", "Hartig", "Tim", "24.05.1990", NutzerrollenTyp.STUDENT);
	}

	@Test
	public void testModulesWithSameBezeichnungAreEqual() {
		assertEquals(g1, g2);
		assertNotEquals(g1, g3);
	}
	
	@Test
	public void testAddedMembersArePartOfTheGroup() {
		assertTrue(g1.addMitglied(u1));
		assertTrue(g1.addMitglied(u2));

		assertTrue(g3.addMitglied(u1));
		assertTrue(g3.addMitglied(u2));
		
		assertTrue(g1.containsBenutzer(u1));
		assertTrue(g1.containsBenutzer(u2));
		
		assertNotEquals(g1, g3);
	}
}
