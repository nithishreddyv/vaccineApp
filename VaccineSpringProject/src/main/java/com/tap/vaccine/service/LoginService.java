package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginService 
{
	private LoginDAO loginDAO;
	private JavaMailSenderImpl javamailSender;

	@Autowired
	public LoginService(LoginDAO loginDAO,JavaMailSenderImpl javamailSender) 
	{
		System.out.println("loginservice object is created by using loginDAO and javamailSender");
		this.loginDAO = loginDAO;
		this.javamailSender=javamailSender;
	}

	public boolean validateLoginCredentials(String email, String password) 
	{
		System.out.println("invoked validateLoginCredentials()");
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
		return flag;
	}
	
	public boolean verifyLoginCredentials(String email,String password)
	{
		System.out.println("invoked verifyLoginCredentials()");
		RegisterEntity entity=loginDAO.getRegisterEntityByEmail(email);
		boolean result=false;
		System.out.println("login attempts"+entity.getLoginAttempt());
		if(entity.getLoginAttempt()>=3) 
		{
			System.out.println("checking login Attempts");
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			simpleMailMessage.setTo(email);
			simpleMailMessage.setSubject("vaccine Application");
			String s="\tYour Account is blocked.Due to many Attempts \n Note:\t"
					+ "Please reset password & login again.";
			simpleMailMessage.setText(s);
			try
			{
				javamailSender.send(simpleMailMessage);
				System.out.println("Mail Sent:.......account is blocked");
			}
			catch(MailException e)
			{
				String message=e.getMessage();
				System.out.println(message);
				return result;
			}
			return result;
		}
		else if(email.equals(entity.getEmail()) && password.equals(entity.getPassword()))
		{
			result=true;
			return result;
		}
		else
		{
			int loginAttempt=entity.getLoginAttempt();
			loginDAO.updateLoginAttempt(email,loginAttempt);
			return false;
		}
	}

}
