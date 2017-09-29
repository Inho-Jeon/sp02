package com.java96.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.java96.dto.MemberDTO;
import com.java96.service.MemberService;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	
	@Autowired
	private MemberService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Login check prehandle....");
		
		
		boolean useSession = request.getSession().getAttribute("memberDTO") !=null?true:false;

		if(useSession) {
			System.out.println("current user use sessin");
			return true;
		}
		
		System.out.println("we need check login cookie");
		
		Cookie loginCookie = WebUtils.getCookie(request, "login");
		
		boolean useCookie = loginCookie != null?true:false;
		
		
		if(useCookie) {
			System.out.println("current user use cookie...");
			
			MemberDTO dto = service.login(loginCookie.getValue());
			
			request.getSession().setAttribute("memberDTO", dto);
			
			return true;
		}
		
		response.sendRedirect("/login");
		return true;
	}

	
}
