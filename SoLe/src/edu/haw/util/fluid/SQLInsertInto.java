package edu.haw.util.fluid;


public class SQLInsertInto extends FluidHelper {

    public SQLInsertInto(String statement) {
        	super(statement);
    }

    public SQLInsertValues values(String[] columnNames) {
        statement += " (";
        statement += columnNames[0];
        for (int i = 1; i < columnNames.length; i++) {
            statement += ", " + columnNames[i];
        }
        statement += ") values(?";
        for (int i = 1; i < columnNames.length; i++) {
            statement += ", ?";
        }
        return new SQLInsertValues(statement + ")");
    }

}
