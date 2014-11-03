package edu.haw.se1.sole.fragenverwaltung;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.Schwierigkeitsgrad;

public interface IFrage {
	
	public ProzentTyp rateLoesung(IFragenloesung fragenLoesung);
	
	public Schwierigkeitsgrad getSchwierigkeitsgrad();

}
