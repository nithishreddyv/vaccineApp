package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register_table")
public class RegisterEntity 
{
	@Column(name="ID")
	@Id
	private int registerID;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="MOBILE_NO")
	private long mobileNo;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DOB")
	private String dOB;
	
	@Column(name="LOGIN_ATTEMPT")
	private int loginAttempt;
	
	@Column(name="MEMBER_COUNT")
	private int memberCount;
	
	public RegisterEntity() 
	{
		
	}

	public RegisterEntity(int registerID, String userName, String email, String password, long mobileNo, String gender,
			String dOB) {
		this.registerID = registerID;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dOB = dOB;
	}

	public RegisterEntity(String userName, String email, String password, long mobileNo, String gender, String dOB) 
	{
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dOB = dOB;
	}

	public int getRegisterID() {
		return registerID;
	}

	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
	
	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}
	
	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	@Override
	public String toString() {
		return "RegisterEntity [registerID=" + registerID + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", mobileNo=" + mobileNo + ", gender=" + gender + ", dOB=" + dOB + "]";
	}
	
}