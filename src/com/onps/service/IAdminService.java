package com.onps.service;

import java.util.ArrayList;

import java.util.logging.Logger;

import com.onps.model.Admin;

/**
 * This is the Voter Service Interface
 */
public interface IAdminService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IAdminService.class.getName());

	/**
	 * Add voters for Admin table
	 * @param Admin
	 */
	public void addAdmin(Admin admin);

	/**
	 * Get a particular Admin
	 * 
	 * @param id
	 * @return Admin
	 */
	public Admin getAdminByID(String id);
	
	/**
	 * Get a list of all voters
	 * 
	 * @return ArrayList<Voter>
	 */
	public ArrayList<Admin> getAdmins();
	
	/**
	 * Update existing Admin
	 * @param id
	 * @param Admin
	 * 
	 * @return Admin
	 */
	public Admin updateAdmin(String id, Admin admin);
	/**
	 * Remove existing Admin
	 * 
	 * @param id
	 */
	public void removeAdmin(String id);
}
