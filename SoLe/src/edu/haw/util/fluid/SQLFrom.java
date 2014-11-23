package edu.haw.util.fluid;

public class SQLFrom extends FluidHelper {


	public SQLFrom(String statement) {
		super(statement);
	}

	public SQLWhere where(String statement) {
		return new SQLWhere(this.statement + " WHERE " + statement);
	}
}
