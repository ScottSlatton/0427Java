package com.bank.service_interface;

import java.util.List;

import com.bank.models.Account;
import com.bank.models.User;
import com.bank.tools.BankException;


public interface AccountServiceInterface {
		
	public Account createAccount(User user, String accountName, String depositAmount) throws BankException;
	public List<Account> listAccounts() throws BankException;
	public List<Account> listUserAccounts(String username) throws BankException;
	public void deposit(User user, String accountName, String depositAmount) throws BankException;
	public void withdraw(User user, String accountName, String depositAmount) throws BankException;
	public void approve(String user_id) throws BankException;



}