package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.RegisterService;

@Controller
public class RegisterController 
{
	private RegisterService registerService;
	
	@Autowired
	public RegisterController(RegisterService registerService) 
	{
		System.out.println("object created by ioc container in RegisterController");
		this.registerService = registerService;
	}
	
	@RequestMapping(value="/openRegisterPage")
	public String gotoRegisterPage(Model model)
	{
		System.out.println("gotoRegisterPage()");
		return "/WEB-INF/register.jsp";
	}
	
	@RequestMapping(value="/register")
	public String register(@RequestParam String username,@RequestParam String email,@RequestParam String password,@RequestParam long mobileNo,
					     @RequestParam String gender,@RequestParam String dob,Model model)
	{
		System.out.println("invoked register()");
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		System.out.println(mobileNo);
		System.out.println(gender);
		System.out.println(dob);
		if(registerService.validateRegister(username, email, password, mobileNo, gender, dob))
		{
			if(registerService.saveRegister(username, email, password, mobileNo, gender, dob))
			{
				model.addAttribute("responseMessage","Data Saved Successfully");
			}
			else
			{
				model.addAttribute("response","email already exists in the database");
			}
		}
		else
		{
			model.addAttribute("Message","Fill the registration form correctly");
		}
		return "/WEB-INF/register.jsp";
	}
	
	@RequestMapping(value="/gotoRegisterToIndex")
	public String gotoRegisterToIndex(Model model)
	{
		System.out.println("gotoRegisterToIndex()");
		return "index.jsp";
	}
	
	@RequestMapping(value="/gotologinToRegister")
	public String gotologinToRegister(Model model)
	{
		System.out.println("gotologinToRegister()");
		return "/WEB-INF/register.jsp";
	}
}
