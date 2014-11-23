package edu.haw.util;

import edu.haw.util.fluid.SQLSelect;

public class SQLStatementBuilder {
	
	public SQLStatementBuilder() {
		super();
	}
	
	public static SQLSelect select(String statement) {
		return new SQLSelect("SELECT " + statement);
	}

}
