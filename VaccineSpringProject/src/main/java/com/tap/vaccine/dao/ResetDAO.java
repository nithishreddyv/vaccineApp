package com.tap.vaccine.dao;

public interface ResetDAO 
{
	boolean resetPasswordByEmail(String email,String password);
}
