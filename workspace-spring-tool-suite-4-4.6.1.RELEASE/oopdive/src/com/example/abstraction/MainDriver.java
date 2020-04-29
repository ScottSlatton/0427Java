package com.example.abstraction;

public class MainDriver {

	public static void main(String[] args) {

		/*
		 * what is abstraction
		 * 	hiding implementation to show functionality
		 * 
		 * How does Java implement?
		 * 		Interfaces--pure form of abstraction
		 * 		Abstract Classes--partial abstraction
		 * 
		 * 
		 * Class inheritance has to be linear
		 *      class to abstract
		 *      class to interface
		 *      abstract to interface
		 */

		Car c = new Volvo();
		System.out.println(c.pi);
		c.drive();
		c.startEngine();
		
		Car j = new Jaguar();
		System.out.println(j.pi);
		j.drive();
		j.startEngine();
		
//		Truck t = new jaguar(); Cant use jaguar cause it does not implement truck
		Truck t = new Volvo();
		t.drive(); //cant use t.startEngine because truck doesnt have startEngine method
		
		/*
		 * Example
		 * 		if product owner wanted a product they will have no idea how to implement it
		 * 		as a developer ill create an interface to make sure i know what functionality ill need
		 */
		
		//Abstract Classes
		
		Prototype p = new Ford();
//		Vehicle p = new Ford(); can go further up too
		p.move();
	}

}
