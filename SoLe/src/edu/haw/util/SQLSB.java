package edu.haw.util;

import edu.haw.util.fluid.FluidHelper;
import edu.haw.util.fluid.SQLInsertInto;
import edu.haw.util.fluid.SQLSelect;

public class SQLSB {
	
	public SQLSB() {
		super();
	}
	
	public static SQLSelect select(String statement) {
		return new SQLSelect("SELECT " + statement);
	}

    public static SQLInsertInto insertInto(String tableName) {
        return new SQLInsertInto("INSERT INTO " + tableName);
    }

}
