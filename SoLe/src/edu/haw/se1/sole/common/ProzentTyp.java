package edu.haw.se1.sole.common;

import java.text.NumberFormat;
import java.util.Locale;

public class ProzentTyp {

	private double percent;

	public ProzentTyp(double percent) {
		this.percent = percent;
		if(percent > 1.0 || percent < 0.0) {
			throw new IllegalArgumentException();
		}
	}
	
	
	@Override
	public String toString() {
		NumberFormat percentFormatter;
		String percentOut;
		Locale locale = Locale.getDefault();
		percentFormatter = NumberFormat.getPercentInstance(locale);
		percentOut = percentFormatter.format(getPercent());
		return percentOut + "   " + locale.toString();
	}
	
	public ProzentTyp add(ProzentTyp otherPercent) {
		return new ProzentTyp(this.getPercent() + otherPercent.getPercent());
	}
	
	public ProzentTyp substract(ProzentTyp otherPercent) {
		return new ProzentTyp(this.getPercent() - otherPercent.getPercent());
	}
	
	public ProzentTyp multiply(ProzentTyp otherPercent) {
		return new ProzentTyp(this.getPercent() * otherPercent.getPercent());
	}
	
	public ProzentTyp divide(ProzentTyp otherPercent) {
		return new ProzentTyp(this.getPercent() / otherPercent.getPercent());
	}

	public double getPercent() {
		return percent;
	}


	public void setPercent(double percent) {
		this.percent = percent;
	}

}
