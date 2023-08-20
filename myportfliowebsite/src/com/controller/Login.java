package com.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.ReadDaoImp;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String check=request.getParameter("check");
		if (check!=null) {
			if (check.equals("logout")) {
				session.removeAttribute("login");
				response.sendRedirect("adminauth.jsp");
			}
		}else {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			
			//validation
			
			//dao
			
			String login = new ReadDaoImp().login(userId,password);
			if (login.equals("exist")) {
				session.setAttribute("login", "exist");
				response.sendRedirect("admin.jsp");
			}
			else {
				session.setAttribute("msg", "userId and password does not exist");
				response.sendRedirect("adminauth.jsp");
			}
		}//end check
		
		
	}

}
