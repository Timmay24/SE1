package edu.haw.se1.sole.fragenverwaltung;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.haw.se1.sole.AppConfig;
import edu.haw.se1.sole.DependencyAssembler;
import edu.haw.se1.sole.belohnungssystem.IBadge;
import edu.haw.se1.sole.belohnungssystem.IBelohnungssystem;
import edu.haw.se1.sole.benutzerverwaltung.IBenutzerverwaltung;
import edu.haw.se1.sole.common.PersistenceService;
import edu.haw.se1.sole.fragenverwaltung.frage.SchwierigkeitsgradTyp;
import edu.haw.se1.sole.fragenverwaltung.frage.musterloesung.MusterloesungMultipleChoice;
import edu.haw.se1.sole.modulverwaltung.IModulverwaltung;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes =AppConfig.class)
@Transactional
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class FrageMultipleChoiceIT {
    
    private IFragenverwaltung fragenVerwaltung;
    private IModulverwaltung modulVerwaltung;
    @Autowired
    DataSource dataSource;
    private IBelohnungssystem belohnungsSystem;
    private IBenutzerverwaltung benutzerVerwaltung;

    private void setUp() {
        DependencyAssembler dAssembler = new DependencyAssembler();
        PersistenceService persistenceService = new PersistenceService();
        persistenceService.setDataSource(dataSource);
        dAssembler.buildDependencies(persistenceService);
        fragenVerwaltung = dAssembler.getFragenVerwaltung();
        modulVerwaltung = dAssembler.getModulVerwaltung();
        belohnungsSystem = dAssembler.getBelohnungsSystem();
        benutzerVerwaltung = dAssembler.getBenutzerVerwaltung();
    }
    
    @Rollback(true)
    @Test
    public void createdMultipleChoiceFrageCanBeSavedToDB() throws Exception {
        setUp();
        IFrage frage = fragenVerwaltung.createFrageMultipleChoice("bla",
                    modulVerwaltung.getModule().get(0),
                    new SchwierigkeitsgradTyp(1),
                    new MusterloesungMultipleChoice(Arrays.asList(new Antwort("antwort1", true), new Antwort("antwort2", false))));
        frage = fragenVerwaltung.saveFrage(frage);
        assertNotEquals(-1, frage.getFrageId());
        assertEquals(new ArrayList<IBadge>(), belohnungsSystem.updateBadgesFor(benutzerVerwaltung.getCurrentUser()));;
    }

}
