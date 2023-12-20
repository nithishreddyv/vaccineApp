package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_table")
public class MemberEntity 
{
	@Column(name="MEMBER_ID")
	@Id
	private int memberID;
	
	@Column(name="MEMBER_NAME")
	private String memberName;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="ID_PROOF")
	private String idProof;
	
	@Column(name="ID_PROOF_NUMBER")
	private String idProofNumber;
	
	@Column(name="VACCINE_TYPE")
	private String vaccineType;
	
	@Column(name="DOSE")
	private int dose;
	
	@Column(name="REF_EMAIL")
	private String refEmail;

	public MemberEntity(int memberID, String memberName, String gender, String dob, String idProof,
			String idProofNumber, String vaccineType, int dose) {
		this.memberID = memberID;
		this.memberName = memberName;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNumber = idProofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}

	public MemberEntity() 
	{
	}

	public MemberEntity(String memberName, String gender, String dob, String idProof, String idProofNumber,
			String vaccineType, int dose) {
		this.memberName = memberName;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNumber = idProofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}
	
	public MemberEntity(String memberName, String gender, String dob, String idProof, String idProofNumber,
			String vaccineType, int dose, String refEmail) {
		this.memberName = memberName;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNumber = idProofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.refEmail = refEmail;
	}

	public MemberEntity(int memberID, String memberName, String gender, String dob, String idProof,
			String idProofNumber, String vaccineType, int dose, String refEmail) {
		this.memberID = memberID;
		this.memberName = memberName;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNumber = idProofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.refEmail = refEmail;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}

	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public String getRefEmail() {
		return refEmail;
	}

	public void setRefEmail(String refEmail) {
		this.refEmail = refEmail;
	}

	@Override
	public String toString() {
		return "MemberEntity [memberID=" + memberID + ", memberName=" + memberName + ", gender=" + gender + ", dob="
				+ dob + ", idProof=" + idProof + ", idProofNumber=" + idProofNumber + ", vaccineType=" + vaccineType
				+ ", dose=" + dose + ", refEmail=" + refEmail + "]";
	}
	
}