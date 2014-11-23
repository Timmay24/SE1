package edu.haw.se1.sole.belohnungssystem;

public interface IBadge {

	public abstract String getName();

	public abstract String getBeschreibung();

	public abstract String getBildPfad();
	
	public abstract boolean validate();

}