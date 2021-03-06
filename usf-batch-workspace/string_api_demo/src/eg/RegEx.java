package eg;

public class RegEx {

	public static void main(String[] args) {
		/*
		 * Reg-Ex - Regular Expression
		 * PMA - Pattern Matching Algorithm
		 * [] - expression
		 * {} - length
		 * ^ - not
		 * ? . * () +
		 * [a-z]{5} - any lowercase letter of length 5
		 * [0-9]{1,} - at least 1 digit and max can be any
		 * [a-zA-Z0-9]{10} - and alphanumeric word of length 10
		 * [^a-zA-Z0-9] - apart from alphanumeric
		 */
		String s="1213sa%*@ASsd  asdf fd   d AA ZZ%%%%)()*(";
		System.out.println(s.replaceAll("[^a-zA-Z]", ""));
		System.out.println(s.replaceAll("[^a-zA-Z]", "").length());
		System.out.println(s.replaceAll("[^a-zA-Z0-9]", ""));
		System.out.println(s.replaceAll("[^a-zA-Z0-9]", "").length());
		System.out.println(s.replaceAll("[ a-zA-Z0-9]", ""));
		System.out.println(s.replaceAll("[ a-zA-Z0-9]", "").length());
		
		//first  5 letters should be uppercase followed by 4 digits and followed by an uppercase letter
		String p="ABXYY112Z";
		if(p.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			System.out.println("Valid info");
		}else {
			System.out.println("Invalid Info");
		}
	}

}
