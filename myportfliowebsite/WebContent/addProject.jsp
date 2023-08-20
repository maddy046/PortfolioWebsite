<%
	String s = (String)session.getAttribute("login");
	if(s==null) /*Token checking*/
	{
		response.sendRedirect("adminauth.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center; color: red">Add Product Section</h1>
	
	<%@include file="messagebox/message.jsp" %>
	
	<p>File size should be less than 1 MB</p>
	<p>File should be jpg/jpeg</p>
	
	<form action="Project" method="post" enctype="multipart/form-data">
		<input type="file" name="project"><br>
		<button>Add</button>
	</form>
</body>
</html>