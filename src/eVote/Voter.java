package eVote;

/**
 * This is the voter model class
 * 
 */

public class Voter {
	private String VoterID;

	private String Name;

	/**
	 * @return the VOterID
	 */
	public String getVoterID() {
		return VoterID;
	}

	/**
	 * @param voterID the voterID to set
	 */
	public void setVoterID(String voterID) {
		VoterID = voterID;
	}

	/**
	 * @return the name
	 */

	public String getNmae() {
		return Name;
	}

	/**
	 * @param voterID the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

}
