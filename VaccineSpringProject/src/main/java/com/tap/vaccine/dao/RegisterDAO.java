package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface RegisterDAO 
{
	boolean save(RegisterEntity registerEntity);
	
	int updateMemberCount(String email,int memberCount);

	int decrementMemberCount(String refEmail, int memberCount);
}