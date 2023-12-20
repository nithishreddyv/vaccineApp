package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.RegisterDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class RegisterService 
{
	private RegisterDAO registerDAO;

	@Autowired
	public RegisterService(RegisterDAO registerDAO) 
	{
		System.out.println("RegisterService object created by using registerDAO");
		this.registerDAO = registerDAO;
	}
	
	public boolean validateRegister(String username,String email,String password,long mobileNo,String gender,String dob)
	{
		System.out.println("invoked validateRegister()");
		boolean flag=false;
		if(username!=null && !username.isEmpty())
		{
			flag=true;
		}
		else
		{
			return false;
		}
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
		if(mobileNo>=0)
		{			
			flag=true;
		}
		else
		{
			return false;
		}
		if(gender!=null && !gender.isEmpty())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(dob!=null && !dob.isEmpty())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		return flag;
	}
	
	public boolean saveRegister(String username,String email,String password,long mobileNo,String gender,String dob)
	{
		System.out.println("invoked saveRegister()");
		RegisterEntity entity=new RegisterEntity(username,email,password,mobileNo,gender,dob);
		boolean result=registerDAO.save(entity);
		return result;
	}
}
