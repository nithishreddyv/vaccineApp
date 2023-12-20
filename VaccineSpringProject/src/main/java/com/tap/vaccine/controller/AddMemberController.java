package com.tap.vaccine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.AddMemberService;

@Controller
public class AddMemberController 
{
	private AddMemberService addMemberService;
	private LoginDAO loginDAO;
	
	public AddMemberController(AddMemberService addMemberService,LoginDAO loginDAO)
	{
		System.out.println("addmembercontroller object is created by using addMemberService");
		this.addMemberService=addMemberService;
		this.loginDAO=loginDAO;
	}
	
	@RequestMapping(value="/gotoHomeToAddMember")
	public String gotoAddMember(Model model)
	{
		System.out.println("invoked gotoAddMember()");
		return "/WEB-INF/addmember.jsp";
	}
	
	@RequestMapping(value="/addmember")
	public String openAddMember(@RequestParam String memberName,
								@RequestParam String gender,
								@RequestParam String dob,
								@RequestParam String idProof,
								@RequestParam String idProofNumber,
								@RequestParam String vaccineType,
								@RequestParam int dose,
								Model model,
								HttpServletRequest request)
	{
		System.out.println("invoked openAddMember()");
		System.out.println(memberName);
		System.out.println(gender);
		System.out.println(dob);
		System.out.println(idProof);
		System.out.println(idProofNumber);
		System.out.println(vaccineType);
		System.out.println(dose);
		HttpSession session=request.getSession(false);
		String refEmail=(String)session.getAttribute("username");
		if(addMemberService.validateAddMember(memberName, gender, dob, idProof, idProofNumber, vaccineType, dose))
		{
			RegisterEntity regEntity=loginDAO.getRegisterEntityByEmail(refEmail);
			if(regEntity.getMemberCount()>=4)
			{
				model.addAttribute("addm","member adding exceeded!...");
				return "/WEB-INF/addmember.jsp";
			}
			else if(addMemberService.saveAddMember(memberName, gender, dob, idProof, idProofNumber, vaccineType, dose,refEmail))
			{
				RegisterEntity registerEntity=loginDAO.getRegisterEntityByEmail(refEmail);
				session.setAttribute("membercount",registerEntity.getMemberCount() );
				int s=(int)session.getAttribute("membercount");
				System.out.println(s+" addmember Controller");
				System.out.println(registerEntity.getMemberCount());
				model.addAttribute("addmm","successfully added");
				return "/WEB-INF/addmember.jsp";
			}
			else
			{
				model.addAttribute("addm","enter valid details");
			}
		}
		else
		{
			model.addAttribute("addm","enter all fields");
		}
		return "/WEB-INF/addmember.jsp";
	}
	
	@RequestMapping(value="/gotoAddmemberToHome")
	public String goaddmemberToHome(Model model)
	{
		System.out.println("invoked goaddmemberToHome()");
		return "/WEB-INF/home.jsp";
	}
	
	@RequestMapping(value="/openViewMembers")
	public String openViewMembers(HttpServletRequest request,Model model)
	{
		System.out.println("invoked openViewMembers()");
		HttpSession session=request.getSession(false);
		String refEmail=(String)session.getAttribute("username");
		List<MemberEntity> entity=addMemberService.getAllMemberEntity(refEmail);
		model.addAttribute("m1","MEMBER_ID");
		model.addAttribute("m2","MEMBER_NAME");
		model.addAttribute("m3","GENDER");
		model.addAttribute("m4","DOB");
		model.addAttribute("m5","ID_PROOF");
		model.addAttribute("m6","ID_PROOF_NUMBER");
		model.addAttribute("m7","VACCINE_TYPE");
		model.addAttribute("m8","DOSE");
		model.addAttribute("m9","EDIT");
		model.addAttribute("m10","DELETE");
		model.addAttribute("members",entity);
		return "/WEB-INF/addmember.jsp";
	}
	
	@RequestMapping(value="/deleteMember/{idProofNumber}")
	public String delete(@PathVariable String idProofNumber,HttpServletRequest request,Model model)
	{
		HttpSession session=request.getSession(false);
		String refEmail=(String)session.getAttribute("username");
		System.out.println("invoked deleteMember() in controller "+idProofNumber);
		boolean result=addMemberService.deleteMemberEntity(idProofNumber,refEmail);
		RegisterEntity regEntity=loginDAO.getRegisterEntityByEmail(refEmail);
		session.setAttribute("membercount",regEntity.getMemberCount() );
		if(result)
		{
			model.addAttribute("responseMessage", "MemberEntity has been deleted");
		}
		else
		{
			model.addAttribute("responseMessage","enter a valid MemberEntity");
		}
		return "redirect:/openViewMembers";
	}
	
	@RequestMapping(value="/editMember/{idProofNumber}")
	public String edit(@PathVariable String idProofNumber,HttpServletRequest request,Model model)
	{
		System.out.println("edit");
		MemberEntity entity=addMemberService.getMemberEntityByIDProofNumber(idProofNumber);
		model.addAttribute("MEMBER_ID",entity.getMemberID());
		model.addAttribute("MEMBER_NAME",entity.getMemberName());
		model.addAttribute("MEMBER_DOB",entity.getDob());
		model.addAttribute("MEMBER_ID_PROOF",entity.getIdProof());
		model.addAttribute("MEMBER_ID_PROOF_NUMBER",entity.getIdProofNumber());
		model.addAttribute("MEMBER_VACCINE_TYPE",entity.getVaccineType());
		model.addAttribute("MEMBER_DOSE",entity.getDose());
		return "/WEB-INF/editMember.jsp";
	}
	
	@RequestMapping(value="/editMember")
	public String updateEntity(	@RequestParam int memberID,
								@RequestParam String memberName,
								@RequestParam String gender,
								@RequestParam String dob,
								@RequestParam String idProof,
								@RequestParam String idProofNumber,
								@RequestParam String vaccineType,
								@RequestParam int dose,
								Model model,
								HttpServletRequest request)
	{
		System.out.println("invoked updateEntity()");
		System.out.println(memberID);
		System.out.println(memberName);
		System.out.println(gender);
		System.out.println(dob);
		System.out.println(idProof);
		System.out.println(idProofNumber);
		System.out.println(vaccineType);
		System.out.println(dose);
		HttpSession session=request.getSession(false);
		String refEmail=(String)session.getAttribute("username");
		if(addMemberService.validateAddMember(memberName, gender, dob, idProof, idProofNumber, vaccineType, dose))
		{
			if(addMemberService.updateAddMember(memberID,memberName, gender, dob, idProof, idProofNumber, vaccineType, dose,refEmail))
			{
				model.addAttribute("addmmm","successfully updated");
				return "/WEB-INF/addmember.jsp";
			}
			else
			{
				model.addAttribute("addm","enter valid details");
			}
		}
		else
		{
			model.addAttribute("addm","enter all fields");
		}
		return "/WEB-INF/editMember.jsp";
	}
	
	@RequestMapping(value="/gotoEditMemberToAddMember")
	public String gotoEditMemberToAddMember()
	{
		System.out.println("invoked gotoEditMemberToAddMember()");
		return "/WEB-INF/addmember.jsp";
	}
}
