package edu.haw.se1.sole.dao;

import java.util.List;

import edu.haw.se1.sole.fragenverwaltung.IFrage;
import edu.haw.se1.sole.fragenverwaltung.frage.FrageMultipleChoice;

public interface IFrageMultipleChoiceDao {
    
    public IFrage getMultipleChoiceFrageBy(int id);
    
    public List<IFrage> getAllMultipleChoiceFragen();
    
    public IFrage saveFrage(FrageMultipleChoice frage);

}
