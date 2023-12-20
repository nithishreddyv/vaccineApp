package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.ResetService;

@Controller
public class ResetController 
{	
	private ResetService resetService;
	
	@Autowired
	public ResetController(ResetService resetService) 
	{
		System.out.println("by using resetservice variable we create Object in ResetController");
		this.resetService = resetService;
	}

	@RequestMapping(value="/openResetPage")
	public String gotoResetPage()
	{
		System.out.println("invoked gotoResetPage()");
		return "WEB-INF/reset.jsp";
	}
	
	@RequestMapping(value="/reset")
	public String openReset(@RequestParam String email,
						  @RequestParam String password,
						  @RequestParam String confirmPassword,
						  Model model)
	{
		System.out.println("invoked openReset()");
		System.out.println(email);
		System.out.println(password);
		System.out.println(confirmPassword);
		if(resetService.validateUserData(email, password, confirmPassword))
		{
			if(resetService.updateNewPassword(email, confirmPassword))
			{
				model.addAttribute("resetloginPage","Successfully reset the password");
				return "/WEB-INF/login.jsp";
			}
			else
			{
				model.addAttribute("resetPage","somethingwent wrong!.. try again...");
			}
		}
		else
		{
			model.addAttribute("resetPage","enter valid data in the reset form");
		}
		return "/WEB-INF/reset.jsp";
	}
}
