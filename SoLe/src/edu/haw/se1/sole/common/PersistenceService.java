package edu.haw.se1.sole.common;

import javax.sql.DataSource;

public class PersistenceService implements IPersistenceService {

    private DataSource dataSource;

    @Override
    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


}
