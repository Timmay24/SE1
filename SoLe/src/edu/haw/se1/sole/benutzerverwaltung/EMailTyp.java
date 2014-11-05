package edu.haw.se1.sole.benutzerverwaltung;

// Example used from http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.haw.se1.sole.common.Immutable;

public class EMailTyp implements Immutable {
	private String 	email;
	private Pattern pattern;
 
	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public EMailTyp(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		if (validate(email))
			this.email = email;
		else
			throw new IllegalStateException("Ungueltige Email-Adresse.");
	}
 
	/**
	 * Validate email with regular expression
	 * 
	 * @param email
	 *            email for validation
	 * @return true valid email, false invalid email
	 */
	public boolean validate(final String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EMailTyp))
			return false;
		EMailTyp other = (EMailTyp) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	

}
