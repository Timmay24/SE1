package edu.haw.se1.sole.fragenverwaltung;

import java.util.Date;

import edu.haw.se1.sole.common.ProzentTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;

public interface IFragenloesung {

	public void rateLoesung();
	
	public ProzentTyp getRating();
	
<<<<<<< HEAD
	public SchwierigkeitsgradTyp getSchwierigkeitsgrad();
=======
	public Schwierigkeitsgrad getSchwierigkeitsgrad();
	
	public Date getBearbeitungsDatum();
>>>>>>> 7364d09ee80bc65668d42bae978cbccabffb36de
}
