package com.bankofben.bankapplication;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidationTools {
	
	public static boolean isValidDateString(String dmy) {
		return dmy.matches("[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}");
	}
	
	public static boolean isValidDate(String ymd) {
		try {
			LocalDate.parse(ymd);
		} catch (DateTimeParseException e) {
			return false;
		}
		return false;
	}
	
	public static boolean isValidUsername(String username) {
		if (username.equals(null)) {
			return false;
		} else if (username.length() < 4 || username.length() > 20) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isValidPassword(String password) {
		/* https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
		 * This regex will enforce these rules:
		 * 		At least one upper case English letter, (?=.*?[A-Z])\
		 * 		At least one lower case English letter, (?=.*?[a-z])
		 * 		At least one digit, (?=.*?[0-9])
		 * 		At least one special character, (?=.*?[.;,#?!@$%^&*-])
		 * 		Minimum eight in length .{8,} (with the anchors)
		 */
		if (password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[.;,#?!@$%^&*-]).{8,}$")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidEmail(String email) {
		if (email.equals(null)) {
			return false;
		}
		// From http://regexlib.com/REDetails.aspx?regexp_id=26
		else if (!(email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|"
				+ "(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"))) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isValidSsn(String ssn) {
		if (ssn.equals(null)) {
			return false;
		}
		else if (ssn.replace(" ", "").replace("-", "").matches("[0-9]{9}")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidPhoneNumber(String phoneNum) {
		if (phoneNum.equals(null)) {
			return false;
		} else {
			String phoneNumber = phoneNum.replace("-", "").replace("(", "").replace(")", "").replace("+1", "");
			if (phoneNumber.matches("[0-9]{10}")) {
				return true;
			} else {
				return false;
			}
		}
	}

}