package com.friendshipBank.presentation;

import com.friendshipBank.exception.BusinessException;
import com.friendshipBank.model.userAccess;
import com.friendshipBank.service.userAccessService;
import com.friendshipBank.service.impl.myScanner;
import com.friendshipBank.service.impl.userAccessServiceImpl;

public class BankApplicationLogin 
{
	public static void LoginToBankApplication() 
	{
		
		userAccessService userService = new userAccessServiceImpl();
		userAccess userAccess = new userAccess();

		String Password1;
		String Password2;
		String accountStatus = "PENDING";
		
    	int userChoice = 0;
 	
    	do {
    		
        	System.out.println();
        	System.out.println("  BANK OF FRIENDSHIP LOGIN PAGE   ");
        	System.out.println("**************************************************");
        	System.out.println("SELECT: (1) LOGIN");
        	System.out.println("SELECT: (2) EXIT THE APPLICATION");
        	System.out.println("SELECT: (3) BACK TO HOMEPAGE");

			userChoice = myScanner.UserInput_Int();

        	switch(userChoice) {
			case 1:
	        	try 
	        	{
	        		System.out.print("Enter Username: ");
	        		String uname = myScanner.UserInput_LongString();
					System.out.print("Enter Password: ");
					String upass = myScanner.UserInput_LongString();
					
					userAccess = userService.loginByUsernameAndPassword(uname, upass);
					
					if(userAccess.getUserName().equals(uname) && userAccess.getUserPassword().equals(upass)) {
						System.out.println("Login success");
					}
					else {
						System.out.println("Login fail");
					}


	        	}
	        	catch (BusinessException e)
	        	{
	    			System.out.println(e.getMessage());
	        	}
	        	

				break;
			case 2:
            	System.out.println();
            	System.out.println("THANK YOU FOR USING MY BANKING APPLICATION");
            	System.out.println();
				System.exit(0);
         		break;
        	
			case 3:
            	System.out.println();
        		welcomePage.BankWelcomePage();
         		break;
        	
        	}
    	}
    	while(userChoice != 3);
		
	}
	
	
	

}