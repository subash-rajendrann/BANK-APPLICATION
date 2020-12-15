package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import com.abc.model.Model;

@WebServlet("/Register")
public class Register extends HttpServlet {
	
	
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String saccno=request.getParameter("accno");
		
		int accno=Integer.parseInt(saccno);
		
		String pswd= request.getParameter("pswd");
		String sbal= request.getParameter("balance");
		
		int balance=Integer.parseInt(sbal);
		
		String email= request.getParameter("email");
		String cusid= request.getParameter("cusid");
		 
		try {
			Model m= new Model();
			
			m.setName(name);
			m.setAccno(accno);
			m.setCusid(cusid);
			m.setBalance(balance);
			m.setPswd(pswd);
			m.setEmail(email);
			Boolean b=m.register();
			if(b==true) {
				response.sendRedirect("/Bankapplication/successreg.html");
				
			}
			else {
				response.sendRedirect("/Bankapplication/failurereg.html");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
