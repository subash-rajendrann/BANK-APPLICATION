package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;

/**
 * Servlet implementation class loan
 */
@WebServlet("/loan")
public class loan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int accno=(int) session.getAttribute("accno");
		String samt=request.getParameter("amt");
		int amt=Integer.parseInt(samt);
		
		try {
			Model m=new Model();
			m.setAccno(accno);
			m.setAmt(amt);
			boolean b=m.loanhistory();
			if(b==true) {
				session.setAttribute("accno", m.getAccno());
				session.setAttribute("email", m.getEmail());
				session.setAttribute("amt", m.getAmt());
				response.sendRedirect("/Bankapplication/loansuccess.jsp");
			}else {
				response.sendRedirect("/Bankapplication/loanfailed.html");
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
