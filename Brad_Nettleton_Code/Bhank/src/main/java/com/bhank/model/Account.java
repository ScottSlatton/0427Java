package com.bhank.model;

public class Account{
	private String id;
	private String customerId;
	private double balance;
	private boolean pending;
	
	public Account() {};
	
	public Account(double balance) {
		this.balance = balance;
		this.pending = true;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isPending() {
		return pending;
	}
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", customerId=" + customerId + ", balance=" + balance + ", pending=" + pending
				+ "]";
	}
}
