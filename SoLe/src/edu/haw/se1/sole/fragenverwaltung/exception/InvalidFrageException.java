package edu.haw.se1.sole.fragenverwaltung.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import edu.haw.se1.sole.fragenverwaltung.IFrage;


public class InvalidFrageException extends Exception {

	private static final long serialVersionUID = -4146719227736845707L;

	private IFrage invalidFrage;
	private Set<String> invalidFields;
	
	public InvalidFrageException(IFrage invalidFrage) {
		super("Invariante von " + IFrage.class + " verletzt.");
		this.invalidFrage = invalidFrage;
		this.invalidFields = new HashSet<>();
	}
	
	public boolean hasInvalidFields() {
		return !invalidFields.isEmpty();
	}
	
	public IFrage getFrage() {
		return this.invalidFrage;
	}
	
	public void addInvalidFields(String... fieldNames) {
		for (String fn : fieldNames)
			addInvalidField(fn);
	}
	
	public void addInvalidField(String fieldName) {
		invalidFields.add(fieldName);
	}
	
	public Collection<String> getInvalidFields() {
		return invalidFields;
	}
	
	public boolean isInvalid(String fieldName) {
		return invalidFields.contains(fieldName);
	}

}
