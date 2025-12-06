package com.expense.password;

//Abstraction used : password validation logic is hidden inside a separate class

// NOTE: For real apps, don't hardcode password — use hashed credentials.
public class PasswordUtil {
	
	private static final String PASSWORD="1234";
	
	public static boolean validatePassword(String input) {
		return PASSWORD.equals(input);
	}

}

