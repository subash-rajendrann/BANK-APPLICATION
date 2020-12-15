package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;

@WebServlet("/transfer")
public class transfer extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		int accno=(int) session.getAttribute("accno");
	String samt=	request.getParameter("amt");
	int amt=Integer.parseInt(samt);
	String sraccno=request.getParameter("raccno");
	int raccno=Integer.parseInt(sraccno);
	try {
		Model m=new Model();
		m.setAccno(accno);
		m.setRaccno(raccno);
		m.setBalance(amt);
	boolean b=	m.transferamt();
	
	
	if(b==true) {
		response.sendRedirect("/Bankapplication/transfersuccess.html");
	}
	else {
		response.sendRedirect("/Bankapplication/transferfail.html");
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
