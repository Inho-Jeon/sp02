package com.java96.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.java96.dto.MemberDTO;

public class LoginAfterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		if(request.getMethod().equals("GET")) {//이메소드 하나만 알고있으면된다.
			return;
		}
		String auto = request.getParameter("auto");
		System.out.println("AUTO:"+auto);
		Map<String, Object> map = modelAndView.getModel();
		
		if(map.get("memberDTO") != null) {//memberDTO로 넣어놓은것이 있으면.....
			//use session
			request.getSession().setAttribute("memberDTO", map.get("memberDTO"));//여기까지는 세션으로 보낼준비만 한것.(설정은 servlet-context.xml에서)
			
			if(auto.equals("on")) {
			//use cookie
			//쿠키값에는 한글을 집어넣지 못한다. 넣을경우 인코딩해서 넣어야한다.
			MemberDTO dto = (MemberDTO)map.get("memberDTO");
			Cookie loginCookie = new Cookie("login",dto.getUid() );
			loginCookie.setMaxAge(60*60*24);
			response.addCookie(loginCookie);//문제는 ID가노출이된다.
		}
	}

	}
}
