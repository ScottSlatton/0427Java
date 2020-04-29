package com.encapsulation;

public class Bank {

	private double account; //No longer have direct access because its private
	
	public Bank() {
		this.account = 0;
	}

	public double getAccount() { //use shift alt s to generate getters/setters
		return account;
	}

	public void setAccount(double account) {
		
		//logic
		
		if(account >10) {
			System.out.println("invalid ammount");
		} else {
		this.account = account;
	}
	}
	
	@Override
	public String toString() { //alt shift s= tostring
		return "Bank [account=" + account + "]";
	}
	
	
}
