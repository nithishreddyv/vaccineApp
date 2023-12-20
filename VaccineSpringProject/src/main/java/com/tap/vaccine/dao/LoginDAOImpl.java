package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginDAOImpl implements LoginDAO
{
	private SessionFactory sessionFactory;
	
	@Autowired
	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("session factory is injected by IOCContainer in LoginDAOImpl");
	}

	@Override
	public RegisterEntity getRegisterEntityByEmail(String email) 
	{
		System.out.println("invoked getRegisterEntityByEmail()");
		Session session=null;
		RegisterEntity entity=null;
		String hql="from RegisterEntity where email='"+email+"'";
		try
		{
			session=this.sessionFactory.openSession();
			Query query=session.createQuery(hql);
			entity=(RegisterEntity)query.uniqueResult();
			System.out.println(entity);
			return entity;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return entity;
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
	public int updateLoginAttempt(String email, int loginAttempt) 
	{
		System.out.println("inbvoked updateLoginAttempt()");
		Session session=null;
		String hql="update RegisterEntity set loginAttempt=:lA where email=:e";
		Transaction t=null;
		Query query=null;
		try
		{
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			query=session.createQuery(hql);
			query.setParameter("lA", loginAttempt+1);
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
}