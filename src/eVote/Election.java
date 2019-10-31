package eVote;

public class Election {
	private int electionId;
	private String name;
	private String year;

	public Election(int electionId, String name, String year) {
		super();
		this.electionId = electionId;
		this.name = name;
		this.year = year;
	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
