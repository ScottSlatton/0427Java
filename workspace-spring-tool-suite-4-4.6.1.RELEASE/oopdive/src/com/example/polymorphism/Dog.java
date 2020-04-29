package com.example.polymorphism;

public class Dog extends Animal{

	boolean hasFur;
	
	public Dog() {
//		super();//refences the Animal class constructor instead of having to write it
//		this.numberOfEyes = 2;
//		this.numberOfLegs = 4;
		this(true);
	}
		public Dog (boolean hasFur) {
			super();
			System.out.println("Inside dog Constructor");
			this.hasFur = hasFur;
		}
	@Override //explicitly tells you when misspelling error
	public void move() {
		System.out.println("Chasing the Bone!!!");
	}
}
