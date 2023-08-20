package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteDaoImp;

/**
 * Servlet implementation class DeleteMessage
 */
@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res = new DeleteDaoImp().deleteMessage(Integer.parseInt(request.getParameter("sno")));
		
		HttpSession session = request.getSession();
		if (res.equalsIgnoreCase("deleted")) {
			session.setAttribute("msg", "deleted successfully");
			response.sendRedirect("readAllMessage.jsp");
		}else {
			session.setAttribute("msg", "something went wrong");
			response.sendRedirect("readAllMessage.jsp");
		}
	}

}
