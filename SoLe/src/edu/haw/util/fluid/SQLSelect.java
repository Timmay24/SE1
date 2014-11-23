package edu.haw.util.fluid;

public class SQLSelect extends FluidHelper {
	
	public SQLSelect(String statement) {
		super(statement);
	}

	public SQLFrom from(String statement) {
		return new SQLFrom(this.statement + " FROM " + statement);
	}

}
