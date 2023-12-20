package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.RegisterDAO;
import com.tap.vaccine.dao.ResetDAOImpl;

@Component
public class ResetService 
{
	private ResetDAOImpl resetDAO;

	@Autowired
	public ResetService(ResetDAOImpl resetDAO) 
	{
		System.out.println("ResetService object created by using ResetDAOImpl");
		this.resetDAO = resetDAO;
	}
	
	public boolean validateUserData(String email,String password,String confirmPassword)
	{
		System.out.println("invoked validateRegister()");
		boolean flag=false;
		if(email!=null && !email.isEmpty())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(password!=null && !password.isEmpty())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(password.equals(confirmPassword))
		{
			flag=true;
		}
		else
		{
			return false;
		}
		return flag;
	}
	
	public boolean updateNewPassword(String email,String password)
	{
		System.out.println("invoked updateNewPassword()");
		boolean result=resetDAO.resetPasswordByEmail(email, password);
		return result;
	}
}
