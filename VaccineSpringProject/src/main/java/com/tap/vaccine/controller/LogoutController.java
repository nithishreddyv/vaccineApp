package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController 
{
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request)
	{
		System.out.println("invoked logout()");
		HttpSession session=request.getSession(true);
		String ob=(String)session.getAttribute("username");
		System.out.println("logout controller"+ob);
		if(session.getAttribute("username")!=null)
		{
			session.removeAttribute("username");
			request.getSession(false);
			session.setAttribute("username", null);
			session.invalidate();
		}
		
		return "/WEB-INF/login.jsp";
	}
}
