package com.company.view.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.view.controller.Controller;

public class LogoutController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("·Î±×¾Æ¿ô Ã³¸®µÊ");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "login";
	}

}
