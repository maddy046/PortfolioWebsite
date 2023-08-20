<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="message/errorpage.jsp" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="messagebox/message.jsp"%>
	 <form action="UploadResume" method="post" enctype="multipart/form-data">
  <input type="file" name="resume" >
  <button>upload</button>
  </form>
</body>
</html>