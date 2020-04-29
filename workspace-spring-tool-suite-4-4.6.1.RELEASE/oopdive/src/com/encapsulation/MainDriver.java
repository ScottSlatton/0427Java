package com.encapsulation;

public class MainDriver {

	public static void main(String[] args) {
		/*
		 * Practice of restricting access to resources within our class.
		 * 
		 * We achieve this through access modifiers within Java;
		 * 	public
		 * 	private
		 * 	protected
		 * 	default(implicit)
		 * 
		 * we set variables to be private and create public getters and setters for the varibale.
		 */

		Bank b = new Bank();
		System.out.println(b.getAccount());
		
		b.setAccount(1000);
		b.setAccount(5);
		System.out.println(b.getAccount());
		
		System.out.println(b.toString());
//		b.account = 1000;
//		System.out.println(b.account);
	}

}
