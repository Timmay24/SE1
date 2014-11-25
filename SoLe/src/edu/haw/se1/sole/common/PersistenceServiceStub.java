package edu.haw.se1.sole.common;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class PersistenceServiceStub implements IPersistenceService {

	public PersistenceServiceStub() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public DataSource getDataSource() {
        // TODO Auto-generated method stub
        return new DataSource() {
			
			@Override
			public <T> T unwrap(Class<T> iface) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void setLoginTimeout(int seconds) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setLogWriter(PrintWriter out) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Logger getParentLogger() throws SQLFeatureNotSupportedException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getLoginTimeout() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public PrintWriter getLogWriter() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Connection getConnection(String username, String password)
					throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Connection getConnection() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		};
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        // TODO Auto-generated method stub
        
    }
	
	

}
