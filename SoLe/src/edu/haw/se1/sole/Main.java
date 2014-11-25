package edu.haw.se1.sole;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.haw.se1.sole.common.PersistenceService;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;

public class Main {
    @Autowired
    private static DataSource dataSource;

	public Main() {
		super();
	}

	public static void main(String[] args) {

	    DependencyAssembler dAssembler = new DependencyAssembler();
		PersistenceService persistenceService = new PersistenceService();
		persistenceService.setDataSource(dataSource);
		dAssembler.buildDependencies(persistenceService);
	}
}

//	      final OracleDataSource odataSource = new OracleDataSource();
//	      odataSource.setURL(config.getProperty("URL"));
//	      odataSource.setUser(config.getProperty("USER"));
//	      odataSource.setPassword(config.getProperty("PASSWORD"));
//	      OracleDataSourceFactory factory = new OracleDataSourceFactory();
//	      final org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
//	      dataSource.setDataSource(odataSource);
//	      dataSource.setMinIdle(1);
//	      dataSource.setMaxActive(20);
//	      dataSource.setMaxIdle(10);
//	      dataSource.createPool();