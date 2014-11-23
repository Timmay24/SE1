package edu.haw.se1.sole.benutzerverwaltung;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.haw.se1.sole.benutzerverwaltung.Benutzer;
import edu.haw.se1.sole.benutzerverwaltung.NutzerrollenTyp;

public class BenutzerTest {
	
	IBenutzer userA;
	IBenutzer userB;
	IBenutzer tim;
	
	@Before
	public void setUp() throws Exception {
		userA = new Benutzer();
		userB = new Benutzer();
		tim = new Benutzer("hacktim", "janeisklar", "tim.hartig@haw-hamburg.de", "Hartig", "Tim", "24.05.1990", NutzerrollenTyp.STUDENT);
	}

	@Test
	public void testDummyUserAreEqualToEachOther() {
		assertEquals(userA, userB);
	}
	
	@Test
	public void testUserWithDifferentBenutzerkennungAreNotEqual() throws Exception {
		assertNotEquals(userA, tim);
	}
	
	@Test
	public void testGeburtsdatum() {
		assertEquals("24.05.1990", tim.getGeburtsdatum().toString());
	}
}
