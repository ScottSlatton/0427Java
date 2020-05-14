package com.bank.dao_implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bank.models.Account;
import com.bank.models.Transaction;
import com.bank.models.User;
import com.bank.tools.BankException;

public class AccountDAOImplementationTest {
	
	AccountDAOImplementation adi = new AccountDAOImplementation();
	UserDAOImplementation udi = new UserDAOImplementation();

	@Test
	public void loggingTransactionDepositTest() throws BankException {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		List<String> allNames = new ArrayList<String>();
		
		String amount = "40.00";
		String account_name = "UNITtest";
		String user_id = "0";
		String type = "deposit";
		

		// try using the logTransaction function
		adi.logTransaction(amount, account_name, user_id, type);
		// Fill empty list with all the transactions from the db table
		transactionList = adi.listAllTransactions();

		// fill the empty string list with all the account names
		for (Transaction t : transactionList) {
			allNames.add(t.getAccount_name());
		}

		// test that we successfully added our test case to the db
		assert(allNames.contains(account_name));
		
		
		// clean it up afterwards
		adi.deleteTransaction(account_name);
	}
	
	
	@Test
	public void testCreateAccount() throws BankException {
		
		Account account = new Account();
		String accountName = "TESTtestUNIT";
		String depositAmount = "100";
		
		User user = new User();
		user.setUsername("UNITtest2");
		user.setPassword("UNITtest2");
		
		udi.createUser(user);
		
		List<Account> accountsBefore = adi.listAccounts();
		int sizeBefore = accountsBefore.size();
		
		adi.createAccount(user, accountName, depositAmount);

		List<Account> accountsAfter = adi.listAccounts();
		int sizeAfter = accountsAfter.size();
		
		assert(sizeBefore < sizeAfter);
						
		udi.deleteUser("UNITtest2");
		adi.deleteAccount("TESTtestUNIT");
	}
	
//	@Test
//	public void depositTest() throws BankException {
////		User user, String accountName, String depositAmount
//		
//		//first create a new user in the db
//		User user = new User();
//		user.setUsername("UNITtest");
//		user.setPassword("test");
//		udi.createUser(user);
//		
//		//then create a new account for that user
//		Account account = new Account();
//		String accountName = "UNITtest";
//		String depositAmount = "10";
//		adi.createAccount(user, accountName, depositAmount);
//
//		// this is the key element of test
//		adi.deposit(user, accountName, depositAmount);
//		System.out.println(account.getBalance());
//		assert(account.getBalance() == 20);
//		
//		//clean up
//		adi.deleteAccount(accountName);
//		udi.deleteUser("UNITtest");
//		
//	}
	
//	@Test
//	public void withdrawalTest() {
//		
//	}
	

}
