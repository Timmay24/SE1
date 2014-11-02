package edu.haw.se1.sole.benutzerverwaltung;

// Example used from http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailTyp {
	private String 	email;
	private Pattern pattern;
	private Matcher matcher;
 
	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public EmailTyp(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		if (validate(email))
			this.setEmail(email);
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
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	private void setEmail(String email) {
		this.email = email;
	}

}
