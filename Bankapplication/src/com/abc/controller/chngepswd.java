package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;

@WebServlet("/chngepswd")
public class chngepswd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pswd=request.getParameter("newpswd");
	HttpSession session=request.getSession();
	int accno=(int) session.getAttribute("accno");
	
	try {
		Model m =new Model();
		m.setAccno(accno);
		m.setPswd(pswd);
		boolean b=m.changePassword();
		if(b==true) {
			response.sendRedirect("/Bankapplication/changepasswordsuccess.html");
		}
		else {
			response.sendRedirect("/Bankapplication/changepasswordfailed.html");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
