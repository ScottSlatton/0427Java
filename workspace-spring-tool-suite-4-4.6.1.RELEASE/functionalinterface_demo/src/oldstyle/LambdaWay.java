package oldstyle;

import oldstyle.MyInterface;

public class LambdaWay {
 public static void main(String[] args) {
	 MyInterface m = () ->{
		 System.out.println("hello lambda");
	 };
	 m.sayHello();
	 MyFunctional f=(n)-> {
		 System.out.println("Hello "+n);
	 };
	 f.hello("Jack");
	 
	 Add a=(x,y,z)->{
		 return x+y+z;
	 };
	 System.out.println(a.sum(10,  88,  99));
	 }
 }
