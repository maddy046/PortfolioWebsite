package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/UploadResume")
@MultipartConfig
public class UploadResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("resume");
		InputStream is = part.getInputStream();
		byte[] b = is.readAllBytes();
//		byte b[]=new byte[is.available()];
		is.read(b);
		//alternative->inputstream.readAllBytes()
		String path = "C:\\Users\\Maddy\\Desktop\\"+"myresume.pdf";;
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(b);
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", "File Uploaded Successfully");
		response.sendRedirect("uploadResume.jsp");
	}

}
