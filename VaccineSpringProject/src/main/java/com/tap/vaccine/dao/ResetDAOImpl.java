package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class ResetDAOImpl implements ResetDAO
{

	private SessionFactory sessionFactory;
	private JavaMailSenderImpl javamailSender;
	
	@Autowired
	public ResetDAOImpl(SessionFactory sessionFactory,JavaMailSenderImpl javamailSender)
	{
		this.sessionFactory = sessionFactory;
		this.javamailSender = javamailSender;
		System.out.println("session factory and javamailSender are injected by IOCContainer in ResetDAOImpl");
	}

	@Override
	public boolean resetPasswordByEmail(String email, String password) 
	{
		System.out.println("invoked resetPasswordByEmail()");
		Session session=null;
		String hql="update RegisterEntity set loginAttempt=:loginAtmt,password=:pwd where email=:e";
		Transaction t=null;
		boolean isDataSaved=false;
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject("vaccine Application");
		String s="\t After reset your password in vaccine application. \n Note:\tIf you want to login use these credentials";
		simpleMailMessage.setText(s+"\n\temail:  "+email+"\n\tNewPassword:   "+password);
		Query query=null;
		try
		{
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			query=session.createQuery(hql);
			query.setParameter("loginAtmt",0);
			query.setParameter("pwd", password);
			query.setParameter("e", email);
			int i=query.executeUpdate();
			javamailSender.send(simpleMailMessage);
			t.commit();
			System.out.println(i);
			System.out.println("Successfully updated new password and loginattempts to 0");
			System.out.println("Mail Sent:.......");
			isDataSaved=true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			t.rollback();
		}
		finally
		{
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataSaved;
	}

}
