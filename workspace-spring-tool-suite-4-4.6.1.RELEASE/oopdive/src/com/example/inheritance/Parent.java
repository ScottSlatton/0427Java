package com.example.inheritance;

public class Parent extends GrandParent{

	/*
	 * Inheritance:
	 * 		A child class can inherit member of a parent class
	 * Why?
	 * 		Minimizes repeating code
	 * Within Java, we're only allowed linear inheritance(when it comes to classes)
	 * and wer're allowed multilevel inheritance
	 */

	String name = "Bruce Wayne";
	
	public void parentMethod() {
		System.out.println("Inside Parent Method!!!");
	}
}