package com.tap.vaccine.dao;

import java.util.List;

import com.tap.vaccine.entity.MemberEntity;

public interface AddMemberDAO 
{
	boolean saveAddMember(MemberEntity entity);
	
	List<MemberEntity> getAllMember(String refEmail);
	
	boolean deleteMemberEntityByidProofNumber(String idProofNumber);
	
	MemberEntity getMemberEntityByIDProofNumber(String idProofNumber);

	boolean updateAddMember(MemberEntity entity);
}