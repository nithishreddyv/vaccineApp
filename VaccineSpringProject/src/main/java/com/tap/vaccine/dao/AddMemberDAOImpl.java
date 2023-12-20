package com.tap.vaccine.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class AddMemberDAOImpl implements AddMemberDAO
{
	private SessionFactory sessionFactory;
	
	@Autowired
	public AddMemberDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("AddMemberDAOImpl object is created by using sessionFactory");
	}

	@Override
	public boolean saveAddMember(MemberEntity entity) 
	{
		System.out.println("invoked saveAddMember()");
		Session session=null;
		boolean isDataSaved=false;
		try
		{
			session=this.sessionFactory.openSession();
			session.beginTransaction();
			Serializable save=session.save(entity);
			System.out.println("save :"+save);
			session.getTransaction().commit();
			System.out.println("addmeber entity has been saved");
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
	public List<MemberEntity> getAllMember(String refEmail) 
	{
		System.out.println("invoked getAllMember() by email");
		Session session=null;
		List<MemberEntity> entity=null;
		String hql="from MemberEntity where refEmail='"+refEmail+"'";
		try
		{
			session=this.sessionFactory.openSession();
			Query query=session.createQuery(hql);
			entity=query.getResultList();
			return entity;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
		}
		return null;
	}

	@Override
	public boolean deleteMemberEntityByidProofNumber(String idProofNumber) 
	{
		System.out.println("invoked deleteMemberEntityByidProofNumber()");
		String hql="delete from MemberEntity where idProofNumber='"+idProofNumber+"'";
		Session session=null;
		Transaction t=null;
		try
		{
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			Query query=session.createQuery(hql);
			int i=query.executeUpdate();
			System.out.println(i);
			t.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
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
	public MemberEntity getMemberEntityByIDProofNumber(String idProofNumber) 
	{
		System.out.println("invoked getMemberEntityByIDProofNumber()");
		Session session=null;
		MemberEntity entity=null;
		String hql="from MemberEntity where idProofNumber='"+idProofNumber+"'";
		try
		{
			session=this.sessionFactory.openSession();
			Query query=session.createQuery(hql);
			entity=(MemberEntity)query.uniqueResult();
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
	public boolean updateAddMember(MemberEntity entity)
	{
		System.out.println("inbvoked updateAddMember()");
		Session session=null;
		Transaction t=null;
		try
		{
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			session.update(entity);
			t.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
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