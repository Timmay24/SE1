package edu.haw.se1.sole.fragenverwaltung;

import java.util.Date;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;

public interface IFragenloesung {

	public void bewerteLoesung();
	
	public ProzentTyp getBewertung();
	
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();
	
	public Date getBearbeitungsDatum();
}
