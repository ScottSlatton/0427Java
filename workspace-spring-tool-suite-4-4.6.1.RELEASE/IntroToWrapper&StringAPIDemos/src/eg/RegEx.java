package eg;

public class RegEx {

	public static void main(String[] args) {
		/*
		 * Reg-Ex=regular expression
		 * PMA-Pattern matching algorithm
		 * []=expression
		 * {}=length
		 * ^=not
		 *  ?, ., *, (), + = other symbol expressions
		 *  [a-z]{5}= any lowercase letter length of 5
		 *  [0-9]{1,}=at least 1 digit and max can be any
		 *  [a-zA-Z0-9]{10}= any alphanumeric word of length 10
		 *  [^a-zA-Z0-9]=apart from alphanumeric
		 */
		
		String s="123123adjfd   asdhfi fd    d AAA   ZZZ%%%%%%%) ()*(";
		System.out.println(s.replaceAll("[^a-zA-Z]", ""));//gives alphabet letters wihtout symbols
		System.out.println(s.replaceAll("[^a-zA-Z]", "").length());//gives number of lettersin string
		
		
		//first 5 letters should be uppercase followed by 4 digits and followed by an uppercase letter
		String p = "ABXYY11210Z";
		if(p.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")){
			System.out.println("Valid info");
		} else {
			System.out.println("Invalid Info");
		}
	}

}
