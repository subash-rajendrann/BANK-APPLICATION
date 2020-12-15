package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusid= request.getParameter("cusid");
		String pswd= request.getParameter("pswd");
		HttpSession session = request.getSession(true);
		
		try {
			Model m =new Model();
			m.setCusid(cusid);
			m.setPswd(pswd);
			boolean b=m.logic();
			if(b==true) {
				session.setAttribute("accno", m.getAccno());
				response.sendRedirect("/Bankapplication/home.html");}
				else {
					response.sendRedirect("/Bankapplication/error.html");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
