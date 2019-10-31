package com.onps.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.onps.model.Candidate;

/**
 * This is the Candidate Service Interface
 */
public interface ICandidateService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ICandidateService.class.getName());

	/**
	 * Add Candidate for Candidate table
	 * @param Candidate
	 */
	public void addCandidate(Candidate candidate);

	/**
	 * Get a particular Candidate
	 * 
	 * @param id
	 * @return Candidate
	 */
	public Candidate getCandidateByID(String id);
	
	/**
	 * Get a list of all Candidate
	 * 
	 * @return ArrayList<Candidate>
	 */
	public ArrayList<Candidate> getCandidates();
	
	/**
	 * Update existing Candidate
	 * @param id
	 * @param candidate
	 * 
	 * @return candidate
	 */
	public Candidate updateCandidate(String id, Candidate candidate);

	/**
	 * Remove existing candidate
	 * 
	 * @param id
	 */
	public void removeCandidate(String id);
}
