package com.application.bank.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.application.bank.dao.AccountDao;
import com.application.bank.exception.BusinessException;
import com.application.bank.models.Account;
import com.application.bank.secrets.SecretStuff;

public class AccountDaoImpl implements AccountDao {
	final static Logger loggy = Logger.getLogger(Account.class);
	
	private static final String myKey = SecretStuff.getAwsKey();
	public static final String URL =
			"jdbc:oracle:thin:@database-1." +  myKey + ".us-east-2.rds.amazonaws.com:1521:orcl";
	public static final String USERNAME = SecretStuff.getAwsUserName();
	public static final String PASSWORD = SecretStuff.getAwsPassword();

	@Override
	public Account insertAccount(Account a) throws BusinessException{
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement("call CREATEBANKACCOUNT(?,?,?,?,?,?,?)");
			
			ps.setString(1, "");
			ps.setString(2, a.getSavingsAccountNumber());
			ps.setString(3, a.getCheckingAccountNumber());
			ps.setString(4, a.getCheckingBalance());
			ps.setString(5, a.getSavingsBalance());
			ps.setString(6, a.getActive());
			ps.setString(7, a.getEmail());
			
			ps.execute();
			
			loggy.info("Creating new account");
		} catch (SQLException e) {
			loggy.error("SQLException- " + e);
			throw new BusinessException("Internal Error. Please contact SYSADMIN");
		}
		return a;
		
		
	}

	@Override
	public Account selectAccountByEmail(String email) throws BusinessException{
		Account a = new Account();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bankaccount WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a.setId(rs.getString("id"));
				a.setSavingsAccountNumber(rs.getString("savingsnumber"));
				a.setCheckingAccountNumber(rs.getString("checkingnumber"));
				a.setCheckingBalance(rs.getString("checkingbalance"));
				a.setSavingsBalance(rs.getString("savingsbalance"));
				a.setActive(rs.getString("active"));
				a.setEmail(rs.getString("email"));
			}	
			loggy.info("Email associated with account-" + a.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
			loggy.warn("Caught SQLException");
			e.printStackTrace();
			throw new BusinessException("Internal Error while updating. Contact SYSADMIN");
			
		}
		return a;
	
	}

	@Override
	public List<Account> selectAllAccounts() throws BusinessException{
		List<Account> aList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bankaccount");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				aList.add(new Account(rs.getString("id"), rs.getString("savingsnumber"), rs.getString("checkingnumber"), 
						rs.getString("checkingbalance"), rs.getString("savingsbalance"), rs.getString("active"), rs.getString("email")));
			}	
			loggy.info("Email associated with account-" + aList.get(2).getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
			loggy.warn("Caught SQLException");
			e.printStackTrace();
			throw new BusinessException("Internal Error while updating. Contact SYSADMIN");
			
		}
		return aList;
	
	}

	@Override
	public void updateAccount(String userEmail, String columnName, String newAtt) throws BusinessException{
		Account a = new Account();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			//PreparedStatement ps = conn.prepareStatement("UPDATE bankaccount SET ? = ? WHERE email = ?");
			PreparedStatement ps = conn.prepareStatement("UPDATE bankaccount SET " + columnName + "  = '" + newAtt + "' WHERE email = '"+ userEmail +"'");
			//PreparedStatement ps = conn.prepareStatement("UPDATE bankaccount SET savingsnumber = '100100' WHERE email = 'jabba@email.com'");
//			ps.setString(1, columnName);
//			ps.setString(2, newAtt);
//			ps.setString(3, userEmail);
			
			ps.executeUpdate();
			loggy.info("Account updated.");
			
		} catch (SQLException e) {
			loggy.warn("Caught SQLException");
			e.printStackTrace();
			throw new BusinessException("Internal Error. Contact SYSADMIN");
		}
		
	}
	
	@Override
	public void deleteAccount(String email) throws BusinessException{
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM bankaccount WHERE email = ?");
			ps.setString(1, email);
			ps.execute();
			loggy.info("Deleting record with email- " + email);
		} catch (SQLException e) {
			loggy.warn("Caught SQLException- " + e);
			e.printStackTrace();
		}
		
	}
	
	public void deleteAllAccounts() throws BusinessException {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM bankaccount");
			
			ps.execute();
			loggy.info("Deleting all rows from Account table");
		} catch (SQLException e) {
			loggy.warn("Caught SQLException- " + e);
			e.printStackTrace();
		}
	}



}























