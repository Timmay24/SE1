package edu.haw.se1.sole.fragenverwaltung;

import java.util.Date;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.Schwierigkeitsgrad;

public interface IFragenloesung {

	public void rateLoesung();
	
	public ProzentTyp getRating();
	
	public Schwierigkeitsgrad getSchwierigkeitsgrad();
	
	public Date getBearbeitungsDatum();
}
