<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Authontication</title>
</head>
<body>
		<%
			String value = (String) session.getAttribute("msg");
			if(value!=null)
			{
		%>
			<h2 style="color: blue; text-align: center;"> <% out.print(value); %> </h2>
		
		<%}
			session.removeAttribute("msg");
		%><br>

	<form action="Login" method="post">
		<h1 style="text-align: center; color: red">Admin Login Section</h1>
		Enter UserId: <input type="text" name="userId" placeholder="enter userid"><br>
		Enter Password: <input type="text" name="password" placeholder="enter password"><br>
		<button>login</button>
	</form>
</body>
</html>