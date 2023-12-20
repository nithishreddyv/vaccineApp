package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.LoginService;

@Controller
public class LoginController 
{
	private LoginService loginService;
	private LoginDAO loginDAO;
	
	@Autowired
	public LoginController(LoginService loginService,LoginDAO loginDAO) 
	{
		System.out.println("object created by ioc container in LoginController");
		this.loginService = loginService;
		this.loginDAO =loginDAO;
	}
	
	@RequestMapping(value="/openLoginPage")
	public String gotoLoginPage(Model model)
	{
		System.out.println("invoked gotoLoginPage()");
		return "/WEB-INF/login.jsp";
	}
	
	@RequestMapping(value="/login")
	public String loginSubmit(@RequestParam String email,@RequestParam String password,Model model,HttpServletRequest request)
	{
		System.out.println("invoked loginSubmit()");
		System.out.println(email);
		System.out.println(password);
		RegisterEntity entity=loginDAO.getRegisterEntityByEmail(email);
		if(loginService.validateLoginCredentials(email,password))
		{
			if(loginService.verifyLoginCredentials(email,password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", email);
				session.setAttribute("membercount",entity.getMemberCount() );
				System.out.println("session....."+session.getAttribute("username"));
				model.addAttribute("useremail",email);
				model.addAttribute("resLogin","Successfully login into the vaccine Application");
				return "/WEB-INF/home.jsp";
			}
			else
			{
				if(entity.getLoginAttempt()==3)
				{
					model.addAttribute("resLoginPage","Account get blocked reset the password and login");
				}
				else
				{
					model.addAttribute("resLoginPage",(3-entity.getLoginAttempt())+" loginAttempts left to block your account");
				}
				return "/WEB-INF/login.jsp";
			}
		}
		else
		{
			model.addAttribute("resLoginPage","Fill the login form correctly");
			return "/WEB-INF/login.jsp";
		}
	}
	
	@RequestMapping(value="/gotoResetToLogin")
	public String gotoResetToLogin(Model model)
	{
		System.out.println("invoked gotoResetToLogin()");
		return "/WEB-INF/login.jsp";
	}
}