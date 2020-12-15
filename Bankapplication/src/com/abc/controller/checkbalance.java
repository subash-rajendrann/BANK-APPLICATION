package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;

@WebServlet("/checkbalance")
public class checkbalance extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	int accno=(int) session.getAttribute("accno");
	try {
		Model m = new Model();
		m.setAccno(accno);
		boolean b=m.checkbal();
		if(b==true) {
			session.setAttribute("balance", m.getBalance());
			response.sendRedirect("/Bankapplication/balanceview.jsp");
		}
		else {
			response.sendRedirect("/Bankapplication/errorbal.html");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
