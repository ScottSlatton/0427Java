package com.bank.presentation;

import com.bank.main.Main;
import com.bank.tools.QuitOption;
import com.bank.presentation.UserLoginView;



//first view for a user who opened the program
public class WelcomeView {
	
	public static void welcome() {
		//first, determine if this is a new user or return user
		String hasAccount = null;

		System.out.println("Welcome to Beaver Trust Fiduciary");
		System.out.println("\nPlease type and enter 'Quit' at any time to exit.");
		System.out.println("\nDo you already have an account? Y or N: ");
		
		//takes user input to either log them in or create account
		hasAccount = Main.scan.nextLine();
		
		if (hasAccount.equalsIgnoreCase("y")) {
			UserLoginView.validateLogin();
		} else if (hasAccount.equalsIgnoreCase("n")) {
			CreateUserAccountView.userCreate();
		} else if (hasAccount.equalsIgnoreCase("quit")) {
			QuitOption.quit();
		} else {
			welcome();
		}
	}

}