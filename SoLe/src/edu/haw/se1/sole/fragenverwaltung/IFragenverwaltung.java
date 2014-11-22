package edu.haw.se1.sole.fragenverwaltung;

public interface IFragenverwaltung {
	
	public IFrage createFrageMultipleChoice();
	public IMusterloesung createMusterloesungMultipleChoice();
	public boolean saveFrage(IFrage frage);

}
