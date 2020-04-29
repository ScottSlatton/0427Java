package com.example.strings;

public class StringStuff {
	
	public static void main(String[] args) {
		/*
		 * What is a string?
		 * an object that contains an array of characters, allowing you to create and manipulate strings
		 * 
		 * immutable: string cant be changed, it just creates a new memory and assigns string to that
		 * final: class cannot be extended
		 * 
		 * string objects are stored in the heap but string literals are stored in strign pool which is in the heap memory
		 */
		
		String s = "This is a string literal"; //string object will first reference string pool
		String s2 = s;//and point to it if it already exists. same as String s2 = "this is a string literal"
		
		String s3 = new String ("This is a string literal");//the new keyword will always create new object in heap memory
		String s4 = new String("This is a string literal");
		
		s4.intern();//moves string from heap to string pool/ it is opposite of new 
		
		System.out.println(s == s2);
		System.out.println(s == s3);
		System.out.println(s3 == s4);
		
		System.out.println(s3.equals(s4));//better to use this method cause it checks contents rather than object creation
	
		//Why immutable?
		
		String A = "Java";
		String B = A;
		
		A = A + " and more Java"; //A now points to "Java and More Java"/not changing string, it is creating a new string
		System.out.println(A);
		System.out.println(B);
		
		System.out.println(A.toUpperCase());//creates new memory  and since never used again it will be garbage collected from memory
		System.out.println(A);
		
		//StringBuilder - mutable, more efficient than StringBuffer
		//StringBuffer - mutable, thread safe/synchronized
		//they exist in the heap
		
		String test = "Rick";
		StringBuilder sb = new StringBuilder(test);//converted string to stringbuilder
		StringBuilder sb2 = sb;
		
		sb.append(" and Morty");
		System.out.println("sb :"+sb);
		System.out.println("sb2 :"+sb2);
		String stringy = sb.toString();//changes stringbuilder back to string
		
		String moreTest = "Morty";
		StringBuffer sbuf = new StringBuffer(moreTest);//converts string to StringBuffer
		sbuf.append(" and Summer");
		System.out.println(sbuf);
		String stringy2 = sbuf.toString();//must change it back to a string to convert to a stringbuilder
		
	}

}
