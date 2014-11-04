package edu.haw.se1.sole.fragenverwaltung.frage;

public class SchwierigkeitsgradTyp {

	private double schwierigkeit;

	public SchwierigkeitsgradTyp(double schwierigkeit) {
		if (0 > schwierigkeit || 10 < schwierigkeit) {
			throw new IllegalArgumentException("Schwierigkeit has to be in range of 1..10.");
		}
		this.schwierigkeit = schwierigkeit;
	}

	public double getSchwierigkeit() {
		return schwierigkeit;
	}
}