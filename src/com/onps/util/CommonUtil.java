package com.onps.util;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.onps.service.IVoterService;

import com.onps.util.CommonConstants;
import com.onps.util.QueryUtil;

/**
 * This is the common utility class to load all property details at once when it is initializing
 */
public class CommonUtil {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IVoterService.class.getName());

	public static final Properties properties = new Properties();
	
	static {
		try {		
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
		}
		catch(IOException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Add new Voter ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateIDs(ArrayList<String> arrayList) {
		String id;
		
		int next = arrayList.size();
		
		next++;
		
		id = CommonConstants.VOTER_ID_PREFIX + next;
		
		if(arrayList.contains(id)) {
			next++;
			
			id = CommonConstants.VOTER_ID_PREFIX + next;
		}
		
		return id;
	}
}
