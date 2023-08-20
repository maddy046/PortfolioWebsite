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
<title>Admin Panel</title>
</head>
<body>
	<h1 style="color: orange; font-style: italic; text-align: center;" >Hello! Welcome to Admin Panel</h1>
	<hr>
	<br>
	<h2 style="color: blue; text-align: center;"><a href="readAllMessage.jsp"><button>Read All Message</button></a></h2>
	<h2 style="color: blue; text-align: left;"><a href="addProject.jsp"><button>Add Project</button></a></h2>
	<h2 style="color: Green; text-align: right;"><a href="projectSection.jsp"><button>Show All Projects</button></a></h2>
	<h2 style="color: Green; text-align: center;"><a href="addEdu.jsp"><button>Add Education</button></a></h2>
	<h2 style="color: blue;"> <a href="uploadResume.jsp">Upload Resume</a> </h2> <br>
	<br>
	<br>
	
	<form action="Login" method="post">
	<input type="hidden" name="check" value="logout">
	<button>Logout</button>
	</form>
	<br>
	
	<button><a href="changeCredentials.jsp">Change Credentials</a></button>
</body>
</html>