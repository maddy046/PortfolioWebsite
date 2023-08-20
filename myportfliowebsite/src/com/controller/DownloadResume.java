package com.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DownloadResume")
public class DownloadResume extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "C:\\Users\\Maddy\\Desktop\\"+"myresume.pdf";

		FileInputStream fis = new FileInputStream(path);
		byte b[]=new byte[fis.available()];
		fis.read(b);
		
		ServletOutputStream os = response.getOutputStream();
		response.setHeader("content-disposition", "filename=myresume.pdf");
		response.setContentType("application/octet-stream");  //for unknown data-> of any type

	}

}
