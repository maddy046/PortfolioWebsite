<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Education Section</title>
</head>
<body>
	<%@include file="messagebox/message.jsp"%>
	<form action="eduback.jsp" method="post">
		<input type="text" name="year" placeholder="enter year"><br>
		<input type="text" name="title" placeholder="enter title"><br>
		<input type="text" name="subtitle" placeholder="enter subtitle"><br>
		<input type="text" name="description" placeholder="enter description"><br>
		<button>Add</button>
		<button style="text-align: right;">
			<a href="admin.jsp">Admin</a>
		</button>
	</form>
</body>
</html>