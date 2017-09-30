package com.bst.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

	private SessionUtil() {
	};

	public static Object getSession(HttpServletRequest request) {
		return request.getSession().getAttribute("user");
	}
	public static Object getSessionAdmin(HttpServletRequest request) {
		return request.getSession().getAttribute("adminSession");
	}

	public static void setAttribute(HttpServletRequest request, Object object) {
		request.getSession().removeAttribute("user");
		request.getSession().setAttribute("user", object);
	}
}
