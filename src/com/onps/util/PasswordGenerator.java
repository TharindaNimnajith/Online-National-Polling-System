package com.onps.util;

import com.onps.util.CommonConstants;

/**
 * This is the random password generator class (generates a random AlphaNumeric String) used when user forgets the password
 */
public class PasswordGenerator {
	// function to generate a random string of length CommonConstants.LENGTH
	public static String getAlphaNumericString() { 
		// chose a Character random from this String 
	    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 
	  
	    // create StringBuffer size of AlphaNumericString 
	    StringBuilder sb = new StringBuilder(CommonConstants.LENGTH); 
	  
	    for(int i = 0; i < CommonConstants.LENGTH; i++) {   
	    	// generate a random number between 0 to AlphaNumericString variable length 
	        int index = (int)(AlphaNumericString.length() * Math.random()); 
	  
	        // add Character one by one in end of sb 
	        sb.append(AlphaNumericString.charAt(index)); 
	    } 
	  
	    return sb.toString(); 
	} 
}
