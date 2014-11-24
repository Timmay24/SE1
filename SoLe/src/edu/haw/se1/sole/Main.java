package edu.haw.se1.sole;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import edu.haw.se1.sole.common.PersistenceService;
import edu.haw.se1.sole.fragenverwaltung.Antwort;
import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.IFragenverwaltung;
import edu.haw.se1.sole.fragenverwaltung.exception.InvalidFrageException;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungMultipleChoice;
import edu.haw.se1.sole.modulverwaltung.IModul;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;
import edu.haw.se1.sole.modulverwaltung.Modul;

public class Main {

	public Main() {
		super();
	}

	public static void main(String[] args) {
	    Properties config = new Properties();
	    FileInputStream inputStream;
	    try {
	        inputStream = new FileInputStream("config.properties");
	        config.load(inputStream);
	    } catch (IOException e) {
	        System.out.println("Couldn't load config file.");
	        e.printStackTrace();
	    }
	    final SingleConnectionDataSource  dataSource = new SingleConnectionDataSource(config.getProperty("URL"),config.getProperty("USER"),config.getProperty("PASSWORD"), true);
	    dataSource.setAutoCommit(true);
	    DependencyAssembler dAssembler = new DependencyAssembler();
		PersistenceService persistenceService = new PersistenceService();
		persistenceService.setDataSource(dataSource);
		dAssembler.buildDependencies(persistenceService);
//		MainWindow.main(null);
		IFragenverwaltung fragenVerwaltung = dAssembler.getFragenVerwaltung();
		IModulverwaltung modulVerwaltung = dAssembler.getModulVerwaltung();
//		IModul modul = modulVerwaltung.createModul("SE1", "AI");
//		modul = modulVerwaltung.saveModul(modul);
		IFrage frageMC;
		try {
			frageMC = fragenVerwaltung.createFrageMultipleChoice("bla",
			        modulVerwaltung.getModule().get(0),
			        new SchwierigkeitsgradTyp(1),
			        new MusterloesungMultipleChoice(Arrays.asList(new Antwort("antwort1", true), new Antwort("antwort2", false))));
			System.out.println("created frage");
			System.out.println(fragenVerwaltung.saveFrage(frageMC).getFrageId());
		} catch (InvalidFrageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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