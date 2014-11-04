package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;

public interface IFragenloesung {

	public void rateLoesung();
	
	public ProzentTyp getRating();
	
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();
}
