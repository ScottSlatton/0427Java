package com.bank.dao_interface;

import java.util.List;

import com.bank.models.Account;
import com.bank.tools.BankException;

public interface AccountDAOInterface {
	
	//abstract methods for interacting with my bank_account table in my db
	
	public Account createAccount(Account account) throws BankException;
	public List<Account> listAccounts() throws BankException;
	public List<Account> listUserAccounts(String username) throws BankException;
	public void deposit(String username, String accountName, String depositAmount) throws BankException;
	public void withdraw(String username, String accountName, String depositAmount) throws BankException;

	

}
