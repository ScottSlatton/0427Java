package com.bankofben.bankapplication;

import java.time.LocalDate;
//import java.time.Period;
//import java.util.List;
//import java.util.ArrayList;
//import java.time.format.DateTimeParseException;

public class Person {
	
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String momsMaidenName;
	protected LocalDate dob;
	protected String ssn;
//	private String stateId;
//	private String streetAddress;
//	private String suiteAptOther;
//	private String zipCode;
	protected String email;
	protected String phoneNumber;
	
	public Person() {
		super();
	}
	
//	public Person(Scanner sc) {
//		super();
//		
//		System.out.println("Please input your first name:");
//		String firstName = sc.nextLine();
//		this.firstName = firstName;
//		
//		System.out.println("Please input your middle name:");
//		String middleName = sc.nextLine();
//		this.middleName = middleName;
//		
//		System.out.println("Please input your last name:");
//		String lastName = sc.nextLine();
//		this.LastName = lastName;
//		
//		System.out.println("Please input your mother's maiden name:");
//		String momsMaidenName = sc.nextLine();
//		this.momsMaidenName = momsMaidenName;
//		
//		boolean noDate = true;
//		while (noDate) {
//			System.out.println("Please input your date of birth in the following format: DD-MM-YYYY");
//			String dmyDob = sc.nextLine();
//			StringBuilder ymdDob = new StringBuilder();
//			for (int i=0; i<3; i++) {
//				ymdDob.append(dmyDob.split("-")[2-i]);
//			}
//			try {
//				LocalDate dob = LocalDate.parse(ymdDob);
//				setDob(dob);
//				noDate = false;
//			} catch (DateTimeParseException e) {
//				System.out.println("Invalid date entry "+dmyDob);
//			}
//		}
//		
//		boolean noSsn = true;
//		while (noSsn) {
//			System.out.println("Please input your social security number: (XXX-XX-XXXX)");
//			String ssn = sc.nextLine();
//			try {
//				setSsn(ssn);
//				noSsn = false;
//			} catch (InvalidSsnException e) {
//				System.out.println("Invalid social security number entry "+ssn);
//			}
//		}
////		this.stateId = stateId;
////		this.streetAddress = streetAddress;
////		this.suiteAptOther = suiteAptOther;
////		this.zipCode = zipCode;
//		
//		boolean noEmail = true;
//		while (noEmail) {
//			System.out.println("Please input your email:");
//			String email = sc.nextLine();
//			try {
//				setEmail(email);
//				noEmail = false;
//			} catch (EmailInvalidException e) {
//				System.out.println("Invalid email entry "+email);
//			}
//		}
//		
//		boolean noPhoneNumber = true;
//		while (noPhoneNumber) {
//			System.out.println("Please input your phone number:");
//			String phoneNumber = sc.nextLine();
//			try {
//				setPhoneNumber(phoneNumber);
//				noPhoneNumber = false;
//			} catch (InvalidPhoneNumberException e) {
//				System.out.println("Invalid phone number entry "+phoneNumber);
//			}
//		}
//	}

	public Person(String firstName, String middleName, String lastName, String momsMaidenName, LocalDate dob,
			String ssn, String email, String phoneNumber) throws BusinessException { 
//					throws BlankFieldException, InvalidDateOfBirthException,
//			InvalidSsnException, InvalidEmailException, InvalidPhoneNumberException {
		super();
		
//		List<String> blankFieldMessages = new ArrayList<>();
		setFirstName(firstName);
		this.middleName = middleName;
		setLastName(lastName);
		setMomsMaidenName(momsMaidenName);
		
		setDob(dob);
		
		setSsn(ssn);
		
		setEmail(email);
		
		setPhoneNumber(phoneNumber);
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) throws BusinessException {
		if (firstName==null) {
			throw new BusinessException("No entry for first name detected. A first name must be provided.");
		} else {
			this.firstName = firstName;
		}
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) throws BusinessException {
		if (lastName==null) {
			throw new BusinessException("No entry for last name detected. A last name must be provided.");
		} else {
			this.lastName = lastName;
		}
	}
	
	public String getMomsMaidenName() {
		return momsMaidenName;
	}
	
	public void setMomsMaidenName(String momsMaidenName) throws BusinessException {
		if (momsMaidenName==null) {
			throw new BusinessException("Mother's maiden name must be provided.");
		} else {
			this.momsMaidenName = momsMaidenName;
		}
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) throws BusinessException {
		if (email==null) {
			throw new BusinessException("No entry detected for social security number. A social security number must be provided.");
		} else if (ValidationTools.isValidSsn(ssn)) {
			this.ssn = ssn;
		} else {
			throw new BusinessException("Invalid social security number.\n"+UserInterface.ssnCriteria());
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws BusinessException {
		if (email==null) {
			throw new BusinessException("No entry detected for email. An email must be provided.");
		}
		if (ValidationTools.isValidEmail(email)) {
			this.email = email;
		} else {
			throw new BusinessException("The entry provided is not a valid email address.");
		}
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) throws BusinessException {
		if (phoneNumber == null) {
			throw new BusinessException("No entry detected for phone number. A phone number must be provided.");
		}
		if (ValidationTools.isValidPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new BusinessException("Invalid phone number.\n"+UserInterface.phoneNumberCriteria());
		}
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) throws BusinessException {
		if (dob==null) {
			throw new BusinessException("No entry for date of birth detected. A date of birth must be provided.");
		} else if (dob.isAfter(LocalDate.now())) {
			throw new BusinessException("Invalid date of birth. Dates of birth cannot occur after the present date.");
		} else {
			this.dob = dob;
		}
	}

}
