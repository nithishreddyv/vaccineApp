package com.tap.vaccine.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class RegisterDAOImpl implements RegisterDAO 
{
	private SessionFactory sessionFactory;
	private JavaMailSenderImpl javamailSender;
	
	@Autowired
	public RegisterDAOImpl(SessionFactory sessionFactory,JavaMailSenderImpl javamailSender) {
		this.sessionFactory = sessionFactory;
		this.javamailSender=javamailSender;
		System.out.println("session factory and javamail is injected by RegisterDAOImpl");
	}
	
	@Override
	public boolean save(RegisterEntity registerEntity) 
	{
		System.out.println("invoked saveRegister()");
		Session session=null;
		boolean isDataSaved=false;
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setTo(registerEntity.getEmail());
		simpleMailMessage.setSubject("vaccine Application");
		String s="\tThank you registering with this vaccine application. \n Note:\tIf you want to login use these credentials";
		simpleMailMessage.setText(s+"\n\tUserName:  "+registerEntity.getUserName()+"\n\tPassword:   "+registerEntity.getPassword());
		try
		{
			session=this.sessionFactory.openSession();
			session.beginTransaction();
			Serializable save=session.save(registerEntity);
			System.out.println("save :"+save);
			javamailSender.send(simpleMailMessage);
			session.getTransaction().commit();
			System.out.println("Register entity has been saved");
			System.out.println("Mail Sent:.......");
			isDataSaved=true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
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

	@Override
	public int updateMemberCount(String email,int memberCount) 
	{
		System.out.println("inbvoked updateMemberCount()");
		Session session=null;
		String hql="update RegisterEntity set memberCount=:mC where email=:e";
		Transaction t=null;
		Query query=null;
		try
		{
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			query=session.createQuery(hql);
			query.setParameter("mC", memberCount+1);
			query.setParameter("e", email);
			int i=query.executeUpdate();
			t.commit();
			System.out.println(i);
			return i;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			t.rollback();
			return 0;
		}
		finally
		{
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
		}
	}

	@Override
	public int decrementMemberCount(String refEmail, int memberCount) 
	{
		System.out.println("inbvoked decrementMemberCount()");
		Session session=null;
		String hql="update RegisterEntity set memberCount=:mC where email=:e";
		Transaction t=null;
		Query query=null;
		try
		{
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			query=session.createQuery(hql);
			query.setParameter("mC", memberCount-1);
			query.setParameter("e", refEmail);
			int i=query.executeUpdate();
			t.commit();
			System.out.println(i);
			return i;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			t.rollback();
			return 0;
		}
		finally
		{
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
		}
	} 
}