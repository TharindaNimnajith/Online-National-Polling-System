package com.onps.service;

import java.util.ArrayList;

import java.util.logging.Logger;

import com.onps.model.Voter;

/**
 * This is the Voter Service Interface
 */
public interface IVoterService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IVoterService.class.getName());

	/**
	 * Add voters for voter table
	 * @param voter
	 */
	public void addVoter(Voter voter);

	/**
	 * Get a particular Voter
	 * 
	 * @param id
	 * @return Voter
	 */
	public Voter getVoterByID(String id);
	
	/**
	 * Get a list of all voters
	 * 
	 * @return ArrayList<Voter>
	 */
	public ArrayList<Voter> getVoters();
	
	/**
	 * Update existing voter
	 * @param id
	 * @param voter
	 * 
	 * @return Voter
	 */
	public Voter updateVoter(String id, Voter voter);

	/**
	 * Remove existing voter
	 * 
	 * @param id
	 */
	public void removeVoter(String id);
}
