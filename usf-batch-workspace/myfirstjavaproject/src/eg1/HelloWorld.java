package eg1;

import eg2.Two;

public class HelloWorld {

	public static void main(String vinay[]) {
		if(vinay.length==2) {
		System.out.println(vinay[0]);
		System.out.println(vinay[1]);
		//System.out.println(vinay[2]);
		System.out.println("Helloooo");
		//return 0;
		iamStatic("Imran");
		HelloWorld h=new HelloWorld();
		h.iAmNonStatic();
		h.iamStatic("Ben");
		h.iAmNonStaticAgain();
		Two t=new Two();
		}else {
			System.out.println("error");
		}
	}
	public static void iamStatic(String name) {
		System.out.println("I am static "+name);
	}
	public void iAmNonStatic() {
		System.out.println("Hey I am non static");
	}
	public void iAmNonStaticAgain() {
		System.out.println("Hey I am non static again");
	}
	private class A{
		
	}
	public static class Z{
		
	}
}
/*
 * 8 primitive data types
 * typename		size		defaultvalue
 * ---------------------------------------
 * byte			1byte			0
 * short		2bytes			0
 * int(default)	4bytes			0
 * long			8bytes			0
 * 
 * float		4bytes			0.0000f
 * double(default)8bytes		0.0000d
 * 
 * char(unicode)2bytes			'\u0000'
 * 
 * boolean		1byte			false	
 * 
 * 
 */

//public class Z{
//	
//}
//class A{
//	
//}
//
//class Z{
//	
//}
/*
 *public
 *protected
 *default
 *private 
 */
