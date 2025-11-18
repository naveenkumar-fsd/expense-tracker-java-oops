package com.expense.password;

//Abstraction used : password validation logic is hidden inside a separate class
public class PasswordUtil {
	
	private static final String PASSWORD="1234";
	
	public static boolean validatePassword(String input) {
		return PASSWORD.equals(input);
	}

}

