package eg_buffer_builder;

public class Palindrome {

	public static void main(String[] args) {
		int x = 121;
		String s =x+"";
//      String s ="Madam";
//		StringBuilder sb = new StringBuilder(s);
//		sb.reverse();
//		String s1 = sb.toString();
//		if(s.equals(s1)) {
//			System.out.println("Its Palindrome");
//		} else {
//			System.out.println("not a Palindroem");
//		}
		
		if(new StringBuilder(s).reverse().toString().equals(s)) {//shorthand of previous code
			System.out.println("Its Palindrome");
			} else {
				System.out.println("not a Palindrome");
	}
		for (int i = 1000; i < 10000; i++) {
			String n = i+"";
			if(new StringBuilder(n).reverse().toString().equals(n)) {
				System.out.println(n);
			}
			
		};
		

}
}
//Print all palindromes bt 1000 to 9999 assignment