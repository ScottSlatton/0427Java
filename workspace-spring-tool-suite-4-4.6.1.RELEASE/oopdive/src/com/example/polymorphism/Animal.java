package com.example.polymorphism;

public class Animal {
	
	public int numberOfEyes;
	public int numberOfLegs;
	
	/*
	 * JVM will give every class a default constructor (if there is no explicit constructor)
	 visibility will also be default
	 */
	//Constructor overloading
	public Animal() { //no Args constructor
		this(2,4); //does same thing as this. = number
		// new Animal(1) separate memory gets created/less efficient
		System.out.println("No args constructor!!!");
//		this.numberOfEyes = 2;
//		this.numberOfLegs = 4;
	}
	
	public Animal(int numberOfLegs) {
		this(2, numberOfLegs);
		System.out.println("1 args constructor");
	}
	
	public Animal(int numberOfEyes, int numberOfLegs) { //Parameterized constructor
//		this(); //imagine this90; being replaced with Animal();/used instead of no args consrtuctor
		System.out.println("Parameterized Constructor");
		this.numberOfEyes = numberOfEyes; //this references to variables belonging to the instance of this class
		this.numberOfLegs = numberOfLegs;
	}
	
	public void move() {
		System.out.println("Animal is moving");
	}
	
	public void eat() {
		System.out.println("Animal is consuming calories");
	}
	
	public void bark() {
		System.out.println("Barking");
	}
  
	public void sleep() {
		System.out.println("Sleeping!!!");
	}
	
	public void sleep(String item) {
		System.out.println("Sleeping with " +item);
	}
	
	public void sleep(int item) {
		System.out.println("sleeping with numbers "+item); // Method overloading
	}
	
	public void sleep(String item, int otherItem) {
		System.out.println("Sleeping with " +item); // Method overloading
	}
	
	public void sleep(int otherItem, String item) {
		System.out.println("sleeping with numbers "+otherItem); // Method overloading
	}
}
