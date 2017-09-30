package com.bst.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bst.entity.Admin;

public class AdminSessionInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Admin admin=(Admin) session.getAttribute("adminSession");
	String	path = request.getServletPath();
	
		if(!path.equals("/admin/admin/loginjsp.html")&&!path.equals("/admin/admin/login.html")){
		if(admin==null){
			
			response.sendRedirect(request.getContextPath()+"/admin/admin/loginjsp.html");
			return false;
		}
		}
		return true;
	}

}
