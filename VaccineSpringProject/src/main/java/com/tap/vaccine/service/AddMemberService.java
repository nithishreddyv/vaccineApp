package com.tap.vaccine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.AddMemberDAO;
import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.dao.RegisterDAO;
import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class AddMemberService 
{
	private AddMemberDAO addMemberDAO;
	private RegisterDAO registerDAO;
	private LoginDAO loginDAO;
	
	@Autowired
	public AddMemberService(AddMemberDAO addMemberDAO,RegisterDAO registerDAO,LoginDAO loginDAO)
	{
		System.out.println("AddMemberService object is created by AddMemberDAOImpl");
		this.addMemberDAO=addMemberDAO;
		this.registerDAO=registerDAO;
		this.loginDAO=loginDAO;
	}
	
	public boolean validateAddMember(String memberName,String gender,String dob,String idProof,
									 String idProofNumber,String vaccineType,int dose)
	{
		System.out.println("invoked validateAddMember()");
		boolean flag=false;
		if(memberName!=null && !memberName.isEmpty() && !memberName.isBlank())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(gender!=null && !gender.isEmpty() && !gender.isBlank())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(dob!=null && !dob.isEmpty() && !dob.isBlank())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(idProof!=null && !idProof.isEmpty() && !idProof.isBlank())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(idProofNumber!=null && !idProofNumber.isEmpty() && !idProofNumber.isBlank())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(vaccineType!=null && !vaccineType.isEmpty() && !vaccineType.isBlank())
		{
			flag=true;
		}
		else
		{
			return false;
		}
		if(dose>0 && dose<=3)
		{
			flag=true;
		}
		else
		{
			return false;
		}
		return flag;
	}
	
	public boolean saveAddMember(String memberName,String gender,String dob,String idProof,
							     String idProofNumber,String vaccineType,int dose,String refEmail)
	{
		System.out.println("invoked saveAddMember()");
		MemberEntity entity=new MemberEntity(memberName,gender,dob,idProof,idProofNumber,vaccineType,dose,refEmail);
		boolean result=addMemberDAO.saveAddMember(entity);
		RegisterEntity regEntity=loginDAO.getRegisterEntityByEmail(refEmail);
		System.out.println(regEntity);
		registerDAO.updateMemberCount(refEmail,regEntity.getMemberCount());
		return result;
	}

	public List<MemberEntity> getAllMemberEntity(String refEmail) 
	{
		System.out.println("invoked getAllMemberEntity()");
		List<MemberEntity> entity=addMemberDAO.getAllMember(refEmail);
		return entity;
	}

	public boolean deleteMemberEntity(String idProofNumber,String refEmail) 
	{
		System.out.println("deleteMemberEntity in service");
		boolean result=addMemberDAO.deleteMemberEntityByidProofNumber(idProofNumber);
		RegisterEntity regEntity=loginDAO.getRegisterEntityByEmail(refEmail);
		registerDAO.decrementMemberCount(refEmail,regEntity.getMemberCount());
		return result;
	}

	public MemberEntity getMemberEntityByIDProofNumber(String idProofNumber)
	{
		System.out.println("getMemberEntityByIDProofNumber");
		MemberEntity entity= addMemberDAO.getMemberEntityByIDProofNumber(idProofNumber);
		return entity;
	}

	public boolean updateAddMember(int memberID,String memberName, String gender, String dob, String idProof, String idProofNumber,
			String vaccineType, int dose, String refEmail) 
	{
		System.out.println("invoked updateAddMember()");
		MemberEntity entity=new MemberEntity(memberID,memberName,gender,dob,idProof,idProofNumber,vaccineType,dose,refEmail);
		boolean result=addMemberDAO.updateAddMember(entity);
		return result;
	}
}
