package not.used;

import java.util.ArrayList;
import java.util.List;

import user.cust.account.models.User;

public class Customer {
	
	/**
	 * not really being used
	 */

	private User user;

	//private List<Account> accounts = new ArrayList<>();
	private Account account;

//	private String name;
//	private String address;
//	private String city;
//	private String state;
//	private String zip;

	// super(userName, password, user_id);

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

//	public List<Account> getAccount() {
//		return account;
//	}
//
//	public void setAccount(List<Account> account) {
//		this.account = account;
//	}
	
	
	

}