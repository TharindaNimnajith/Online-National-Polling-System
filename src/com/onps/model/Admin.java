package com.onps.model;

/**
 * This is the Voter model class
 */

public class Admin {
	private String id;	
	
	private String username;
	
	private String nic;
	
	private String password;
	
	private String email;
	
	private String userType;
	
	private boolean isVoted;
	
	private String fname;
	
	private String lname;
	
	private String address;
	
	private String district;
	
	private String province;
	
	private String gender;
	
	private String DoB;
	
	private String phoneNo;
	
	/**
	 * 
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
		
		id = "";
		username = "";
		nic = "";
		password = "";
		email = "";
		userType = "";
		isVoted = false;
		fname = "";
		lname = "";
		address = "";
		district = "";
		province = "";
		gender = "";
		DoB = "";
		phoneNo = "";
	}

	/**
	 * @param id
	 * @param username
	 * @param nic
	 * @param password
	 * @param email
	 * @param userType
	 * @param isVoted
	 * @param fname
	 * @param lname
	 * @param address
	 * @param district
	 * @param province
	 * @param gender
	 * @param DoB
	 * @param phoneNo
	 */
	public Admin(String id, String username, String nic, String password, String email, String userType, boolean isVoted,
			String fname, String lname, String address, String district, String province, String gender, String DoB,
			String phoneNo) {
		
		super();
		
		this.id = id;
		this.username = username;
		this.nic = nic;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.isVoted = isVoted;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.district = district;
		this.province = province;
		this.gender = gender;
		this.DoB = DoB;
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}
	
	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * @return the isVoted
	 */
	public boolean isVoted() {
		return isVoted;
	}
	
	/**
	 * @param isVoted the isVoted to set
	 */
	public void setVoted(boolean isVoted) {
		this.isVoted = isVoted;
	}
	
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the DoB
	 */
	public String getDoB() {
		return DoB;
	}
	
	/**
	 * @param DoB the DoB to set
	 */
	public void setDoB(String DoB) {
		this.DoB = DoB;
	}
	
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Id = " + id + "\n" + "Username = " + username + "\n" + "NIC = " + nic + "\n" + "Password = " + password + "\n" 
				+ "E-mail = " + email + "\n" + "User Type = " + userType + "\n" + "Is Voted = " + isVoted + "\n" 
				+ "First Name = " + fname + "\n" + "Last Name = " + lname + "\n" + "Address = " + address + "\n" 
				+ "District = " + district + "\n" + "Province = " + province + "\n" + "Gender = " + gender + "\n"
				+ "Date of Birth = " + DoB + "\n" + "Phone No = " + phoneNo + "\n";
	}
}
