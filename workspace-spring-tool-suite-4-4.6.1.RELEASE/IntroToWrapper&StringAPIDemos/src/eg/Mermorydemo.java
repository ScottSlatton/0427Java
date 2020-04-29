package eg;

public class Mermorydemo {
	
	public static void main(String[] args) {
	String s1 = "hello";
	String s2 = "hello";
	String s3 = new String("hello");
	System.out.println(System.identityHashCode(s1));
	System.out.println(System.identityHashCode(s2));
	System.out.println(System.identityHashCode(s3));
	s3 = s3.intern();
	System.out.println(System.identityHashCode(s3));
	
	System.out.println(s2.equalsIgnoreCase("Hello"));//not case sensitive
	System.out.println(s2.equals("HELLO"));//case sensitive
	
	System.out.println(s2.substring(1));
	System.out.println(s2.substring(2, 4));
	
	System.out.println(s2.length());
	System.out.println(s2.charAt(0));
	
	for(int i=0; i < s2.length(); i++) {
		System.out.println(s2.charAt(i));//prints out each character of hello
	}
	String s = "   lsjdgdad dhgd dd dd    ";
	System.out.println(s);
	System.out.println(s.trim());//takes out white spaces
	
	s="hello hi how are you doing today?";
	String ar[]=s.split(" ");
	for (int i = 0; i < ar.length; i++) {
		System.out.println(ar[i].toUpperCase()); //prints out each word on seperate line
	}
	
	}
}
