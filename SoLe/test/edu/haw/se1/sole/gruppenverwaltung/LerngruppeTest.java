package edu.haw.se1.sole.gruppenverwaltung;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.haw.se1.sole.benutzerverwaltung.Benutzer;
import edu.haw.se1.sole.benutzerverwaltung.NutzerrollenTyp;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class LerngruppeTest {

	Lerngruppe g1;
	Lerngruppe g2;
	Lerngruppe g3;
	
	Benutzer u1;
	Benutzer u2;
	
	@Before
	public void setUp() throws Exception {
		g1 = new Lerngruppe("g1", new Modul("mod1", "ai", "haw"));
		g2 = new Lerngruppe("g1", new Modul("mod1", "ai", "haw"));
		g3 = new Lerngruppe("g3", new Modul("mod3", "ai", "haw"));
		
		u1 = new Benutzer();
		u2 = new Benutzer("hacktim", "janeisklar", "tim.hartig@haw-hamburg.de", "Hartig", "Tim", "24.05.1990", NutzerrollenTyp.STUDENT);
	}

	@Test
	public void testEquals() {
		assertEquals(g1, g2);
		assertNotEquals(g1, g3);
	}
	
	@Test
	public void testAddMember() {
		assertTrue(g1.addMiglied(u1));
		assertTrue(g1.addMiglied(u2));

		assertTrue(g3.addMiglied(u1));
		assertTrue(g3.addMiglied(u2));
		
		assertTrue(g1.containsMember(u1));
		assertTrue(g1.containsMember(u2));
		
		assertNotEquals(g1, g3);
	}
}
