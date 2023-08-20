package com.controller;

import java.io.File;
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

import com.dao.DeleteDaoImp;
import com.dao.InsertImp;
import com.validation.Validation;

@MultipartConfig
@WebServlet("/Project")
public class Project extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = request.getParameter("check");
		if (check != null) {
			if (check.equals("deleteProject")) {
				String sno = request.getParameter("sno");
				String fileName = request.getParameter("fileName");

				// delete from database
				String res = new DeleteDaoImp().deleteProject(Integer.parseInt(sno));
				if (res.equals("deleted")) {
					// delete from the directory
					try {
						String path = "F:\\Seedinfotech\\Advance Java\\MyPortfolioWebsite\\myportfliowebsite\\WebContent\\images\\myproject\\"
								+ fileName;
						new File(path).delete();

						session.setAttribute("msg", "project delete successfully");
						response.sendRedirect("projectSection.jsp");
					} catch (Exception e) {

						session.setAttribute("msg", "something went wrong");
						response.sendRedirect("projectSection.jsp");
					}
				} else {
					session.setAttribute("msg", "something went wrong");
					response.sendRedirect("projectSection.jsp");
				}
			} else {
				session.setAttribute("msg", "something went wrong");
				response.sendRedirect("projectSection.jsp");
			}
		} else {

			Part part = request.getPart("project");
			String fileName = part.getSubmittedFileName();
			System.out.println(fileName);

			// validation
			String result = new Validation().validateImage(part);
			if (result.equals("valid")) {
				// dao
				String saveProject = new InsertImp().saveProject(fileName);
				if (saveProject.equals("saved")) {
					try {
						// file io
						InputStream is = part.getInputStream();
						byte[] b = is.readAllBytes();
						is.read(b);
						String path = "F:\\Seedinfotech\\Advance Java\\MyPortfolioWebsite\\myportfliowebsite\\WebContent\\images\\myproject\\"
								+ fileName;
						FileOutputStream fos = new FileOutputStream(path);
						fos.write(b);
						session.setAttribute("msg", "file upload successfully");
						response.sendRedirect("addProject.jsp");

					} catch (Exception e) {
						// Dao-> Delete uploaded image file
						System.out.println("fileUploadExp->" + e);
						session.setAttribute("msg", "something went wrong");
						response.sendRedirect("addProject.jsp");
					}
				} else {
					session.setAttribute("msg", "something went wrong");
					response.sendRedirect("addProject.jsp");
				}
			} else {
				session.setAttribute("msg", result);
				response.sendRedirect("addProject.jsp");
			}

		}

	}

}
