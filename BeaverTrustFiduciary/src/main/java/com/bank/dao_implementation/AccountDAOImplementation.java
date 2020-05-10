package com.bank.dao_implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao_interface.AccountDAOInterface;
import com.bank.models.Account;
import com.bank.models.User;
import com.bank.tools.BankException;
import com.bank.tools.DataConnection;

public class AccountDAOImplementation implements AccountDAOInterface {
	// use this for the doubles $$$$

	@Override
	public Account createAccount(User user, String accountName, String depositAmount) throws BankException {
		Account account = new Account();
		
		try (Connection conn = DataConnection.getConnection()) {
			String sql = "{call create_new_account(?,?,?,?)}";
			CallableStatement cb = conn.prepareCall(sql);
			
			cb.setString(2, user.getUser_id());
			cb.setString(3, accountName);
			cb.setDouble(4, Double.parseDouble(depositAmount));
			
			cb.registerOutParameter(1, java.sql.Types.VARCHAR);
			
			cb.execute();
			
			account.setAccount_id(cb.getString(1));					
					
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankException("ACCOUNT DAO IMPLEMENTATION ERROR");
		}
		
		return account;
	}
	
	// LIST ALL THE ACCOUNTS, for the EMPLOYEE
	@Override
	public List<Account> listAccounts() throws BankException {
		List<Account> accountList = new ArrayList<Account>();
		
		try (Connection conn = DataConnection.getConnection()) {
			String sql = "select * from bank_account";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				accountList.add
					(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankException("trouble with the account dao");
		}
		
		System.out.println("All accounts: " + accountList.toString());
		return accountList;
	}

	// LIST JUST THE CURRENT USERS ACCOUNTS
	@Override
	public List<Account> listUserAccounts(String username) throws BankException {
		List<Account> accountList = new ArrayList<Account>();
		
		try (Connection conn = DataConnection.getConnection()) {
			String sql = "select * from bank_account inner join bank_user on bank_account.user_id = bank_user.user_id where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				accountList.add
				(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BankException("something wrong with list users account dao layer");
		}
		return accountList;
	}
	
	// LOG ALL TRANSACTIONS WHEN MAKING DEPOSIT or WITHDRAWAL
	public void logTransaction(String amount, String accountName, String user_id, String type) throws BankException {
//		System.out.println(amount + accountName + user_id + type);
		String sql = "{call create_new_transaction(?,?,?,?,?)}";
		try (Connection conn = DataConnection.getConnection()) {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(2, Double.parseDouble(amount));
			cs.setString(3, accountName);
			cs.setString(4, user_id);
			cs.setString(5, type);
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			
			cs.execute();

//			int rs2 = ps.executeUpdate();
			
//			try (Connection conn = DataConnection.getConnection()) {
//				String sql = "{call create_new_account(?,?,?,?)}";
//				CallableStatement cb = conn.prepareCall(sql);
//				
//				cb.setString(2, user.getUser_id());
//				cb.setString(3, accountName);
//				cb.setDouble(4, Double.parseDouble(depositAmount));
//				
//				cb.registerOutParameter(1, java.sql.Types.VARCHAR);
//				
//				cb.execute();
//				
//				account.setAccount_id(cb.getString(1));	
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankException("trouble with LOG TRANSACTION IN DAO");
		}
	}
	

	
	// DEPOSIT INTO ACCOUNT
	@Override
	public void deposit(User user, String accountName, String depositAmount) throws BankException {
		String user_id = user.getUser_id();
		String sql2 = 
				"update bank_account set account_balance = (account_balance + ?) where account_name = ? and user_id = ?";

				// then use that user id to access account and update balance
				try (Connection conn2 = DataConnection.getConnection()) {
					PreparedStatement ps2 = conn2.prepareStatement(sql2);
					ps2.setDouble(1, Double.parseDouble(depositAmount));
					ps2.setString(2, accountName);
					ps2.setString(3, user_id);
					logTransaction(depositAmount, accountName, user_id, "deposit");
					ps2.executeUpdate();
					

				} catch (SQLException e) {
					e.printStackTrace();
					throw new BankException("trouble with make deposit in accout dao");
				}
			}


	// WITHDRAW from ACCOUNT
	@Override
	public void withdraw(User user, String accountName, String withdrawalAmount) throws BankException {
		String user_id = user.getUser_id();
		String sql2 = 
				"update bank_account set account_balance = (account_balance - ?) where account_name = ? and user_id = ?";

				try (Connection conn2 = DataConnection.getConnection()) {
					PreparedStatement ps2 = conn2.prepareStatement(sql2);
					ps2.setDouble(1, Double.parseDouble(withdrawalAmount));
					ps2.setString(2, accountName);
					ps2.setString(3, user_id);
					logTransaction(withdrawalAmount, accountName, user_id, "withdrawal");
					
					int rs2 = ps2.executeUpdate();
					

				} catch (SQLException e) {
					e.printStackTrace();
					throw new BankException("trouble with make deposit in accout dao");
				}
			}


	
	// EMPLOYEE APPROVING ACCOUNT
	@Override
	public void approve(String user_id) throws BankException {
//		System.out.println("test at adi level");
//		System.out.println(user_id);
		String sql = "update bank_user set approved = 1 where user_id = ?";
		
		try (Connection conn = DataConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankException("trouble with approving account at dao level");
		}
	}
	
}
