package edu.haw.se1.sole.common;

import javax.sql.DataSource;

public interface IPersistenceService {
    
    public DataSource getDataSource();
    
    public void setDataSource(DataSource dataSource);
}