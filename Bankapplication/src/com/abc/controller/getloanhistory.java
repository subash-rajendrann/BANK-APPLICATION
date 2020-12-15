package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;

@WebServlet("/getloanhistory")
public class getloanhistory extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	int accno=(int)session.getAttribute("accno");
	try {
		Model m=new Model();
		m.setAccno(accno);
		ArrayList al=m.getloanhistory();
		if(al.isEmpty()==false) {
			session.setAttribute("lacc", m.lacc);
			session.setAttribute("lemail", m.lemail);
			session.setAttribute("lamt", m.lamt);
			response.sendRedirect("/Bankapplication/loanhistory.jsp");}
			else {
				response.sendRedirect("/Bankapplication/loanstatementfailed.html");
			}
			
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
