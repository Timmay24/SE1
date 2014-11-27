package edu.haw.se1.sole.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageMultipleChoice;

public interface IFrageMultipleChoiceDao {
    
    public IFrage getMultipleChoiceFrageBy(int id);
    
    public List<IFrage> getAllMultipleChoiceFragen();
    
    /**
     * @param frage Frage, die in der Persistenz gespeichert werden soll
     * @return Ein neues Objekt der gespeicherten Frage mit aktualisierter ID aus der Persistenz
     * @pre {@code Assert.notNull(frage)}
     */
    public IFrage saveFrage(FrageMultipleChoice frage);

}
