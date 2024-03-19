package edu.depaul.shoppingsystem.user;

import edu.depaul.shoppingsystem.log.*; // access to Logging

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

// User authentication system where customers can log in, and their cart data will be associated with their accounts.

public class UserAuthentication {
	// path to file containing user credentials
	private static final String userCredentialsFile = "data/userCredentials.txt"; // relative path, file in src folder
	
	// user credentials map, with usernames as keys and hash passwords as values
	private Map<String, String> userCredentials; 
	
	// constructor initializes userCredentials map and loads credentials from file
	public UserAuthentication() {
        userCredentials = new HashMap<>();
        loadUserCredentialsFromFile();
    }
	
	// use Logging class to log errors
	private void logError(String message) {
		Logging.error("UserAuthentication", message);
    }
	
    // use Logging class to log info messages
    private void logInfo(String message) {
        Logging.info("UserAuthentication", message);
    }

	// loads user credentials from a file and stores them in map
	private void loadUserCredentialsFromFile() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(userCredentialsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	// splits each line into username and password parts
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String hashedPassword = parts[1].trim();
                    // stores username and hashed password in map
                    userCredentials.put(username, hashedPassword);
                } else {
                	// logs an error if format of credentials is incorrect
                    logError("Invalid user credentials format: " + line);
                }
            }
        } catch (IOException e) {
        	// logs an error if there's an issue reading the file
            logError("Error reading user credentials file: " + e.getMessage());
        }
    }
	
	// authenticates a user by comparing hashed version of input password with stored hash
	public boolean authenticateUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String storedHashedPassword = userCredentials.get(username);
            String hashedInputPassword = hashPassword(password);
            // returns true if hashed passwords match
            if (storedHashedPassword.equals(hashedInputPassword)) {
                logInfo("User " + username + " authenticated successfully.");
                return true;
            }
            
            // authentication failed (username not found or incorrect password)
            else {
            	logError("Failed login attempt for username: " + username);
                return false;
            }
        }
	    else {
	    	logError("Username not found: " + username);
	        return false;
	    }
    }
	
	// hashes password using SHA-256 (algorithm generates 32-byte signature)
	private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            logError("Hashing algorithm not found: " + e.getMessage());
            return null;
        }
    }
	
	// converts byte array into hex string 
	private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
	}
	
	// create new account 
    public boolean createNewAccount(String username, String password) {
        // check if username already exists
        if (userCredentials.containsKey(username)) {
            logError("Attempt to create a duplicate account with username: " + username);
            return false;
        }

        // validate the password
        if(!validatePassword(password)) {
        	logError("Password does not meet the requirements.");
            return false;
        }
        
        // hash the new password
        String hashedPassword = hashPassword(password);
        if (hashedPassword != null) {
        	// store new credentials in map
        	userCredentials.put(username, hashedPassword);
        	
        	// append new credentials to file
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(userCredentialsFile), StandardOpenOption.APPEND)) {
                writer.write(username + ":" + hashedPassword);
                writer.newLine();
                logInfo("Account created successfully for username: " + username);
                return true;
            } catch (IOException e) {
                logError("Error writing new user credentials to file: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
    
    // user password validation
    private boolean validatePassword(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");
        boolean isLongEnough = password.length() >= 8;

        if (!hasUppercase || !hasLowercase || !hasDigit || !hasSpecial || !isLongEnough) {
            logError("Password validation failed. Requirements not met.");
            return false;
        }
        return true;
    }
        
}
    
 

