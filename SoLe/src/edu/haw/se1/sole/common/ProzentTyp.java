package edu.haw.se1.sole.common;

import java.text.NumberFormat;
import java.util.Locale;

public class ProzentTyp {

	private double percent;

	public ProzentTyp(double percent) {
		this.setPercent(percent);
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
		return percentOut;
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

	private void setPercent(double percent) {
		this.percent = percent;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(percent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProzentTyp))
			return false;
		ProzentTyp other = (ProzentTyp) obj;
		if (Double.doubleToLongBits(percent) != Double
				.doubleToLongBits(other.percent))
			return false;
		return true;
	}
	
	
}
