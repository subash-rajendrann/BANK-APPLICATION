package com.abc.controller;

import java.io.IOException;


import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/ChangePassword" }, servletNames = { "chngepswd" })
public class ChangePassword implements Filter {

   

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String newpswd=request.getParameter("newpswd");
		String confpswd=request.getParameter("confmpswd");
		if(newpswd.equals(confpswd)) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("/changepasswordfailed.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
