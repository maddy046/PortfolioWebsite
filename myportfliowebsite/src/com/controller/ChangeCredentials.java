package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UpdateDaoImp;

@WebServlet("/ChangeCredentials")
public class ChangeCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ChangeCredentials() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			
			//validation(no need)
			
			//Dao
			HttpSession session = request.getSession();
			String updateCredentials = new UpdateDaoImp().updateCredentials(userId,password);
			if (updateCredentials.equals("updated")) {
				session.removeAttribute("login");
				session.setAttribute("msg", "Credentials Updated Successfully");
				response.sendRedirect("adminauth.jsp");
			}else {
				session.setAttribute("msg", "Something went wrong: not updated");
				response.sendRedirect("ChangeCredentials.jsp");
			}
	}

}
