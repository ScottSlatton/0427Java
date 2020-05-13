package com.example.Wrappers;

public class MainDriver {
	
	public static int myMethod(int a) {
		System.out.println("Inside Primitive");
		return a;
	}
	
	public static Integer myMethod(Integer a) {
		System.out.println("Inside Object");
		return a;
	}

	public static void main(String[] args) {

		/*
		 * A wrapper class will wrap around primitive data types
		 * 
		 * boolean>Boolean
		 * int>Integer
		 * char>Character
		 * byte>Byte
		 * short>Short
		 * long>Long
		 * double>Double
		 * 
		 * why?
		 * 		Objects have methods associated with them
		 * 		Data Structures like the collection API
		 */
		
		int i = 5;
		
		//boxing
		Integer j = new Integer(5); //adds more methods associated with it in the drop down box
		//autoboxing
		Integer k = 3;//Where is the new?
		//unboxing
		int l = k;
		
		String s = "123";
		Integer g = Integer.parseInt(s);
		System.out.println(g);
		
		System.out.println(Integer.MAX_VALUE);//If capitalizaed is static final variable
		System.out.println(Long.MAX_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);

		myMethod(g);
		myMethod(5);

	}

}