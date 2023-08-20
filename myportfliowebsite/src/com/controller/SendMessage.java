package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.InsertImp;
import com.validation.Validation;

@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		String res = new Validation().validateData(name,email,message);
		System.out.println(res);
		
		HttpSession session = request.getSession();
		
		if (res.equalsIgnoreCase("valid")) {
			//dao
			System.out.println("************");
			String saveMessage = new InsertImp().saveMessage(name, email, message);
			if (saveMessage.equals("saved")) {	
				
				session.setAttribute("msg", "*********Message Sent Successfully*******");
				response.sendRedirect("index.jsp");
				System.out.println(saveMessage);
			}else {
				
				session.setAttribute("msg", "😥😥 Something Went Wrong 😫😫 ");
				response.sendRedirect("index.jsp");
				System.out.println(saveMessage);
			}
		}else {
			System.out.println(res);
		}
	}

}
