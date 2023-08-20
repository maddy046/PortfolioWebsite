<%@page import="com.entity.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ReadDaoImp"%>
<%@page errorPage="message/errorpage.jsp" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

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
<title>Read All Projects</title>
</head>
<body>
	<h1 style="text-align: center;color: brown ">All Projects Section</h1>
	<br>

	<hr>
	<br>
	<%@include file="messagebox/message.jsp"%>

	<c:set var="k" value="this is my car"></c:set>
	<!-- jstl Core Examples-->
<!-- 	<c:set var="k" value="10"></c:set>
	<c:out value="${k}"></c:out>
	<br>

	<c:if test="${k<15}">
		Html code 1
		</c:if>

	<c:if test="${k>15 && k<50}">
		Html code 2
		</c:if>

	<c:if test="${k>50}">
		Html code 3
		</c:if>

	<c:choose>
		<c:when test="${k<15}">
				Run 1<br>
		</c:when>

		<c:when test="${k>15 && k<50}">
				Run 2<br>
		</c:when>

		<c:when test="${k>50}">
				Run 3<br>
		</c:when>
	</c:choose>
 -->
 	<!--  Functions Tags
    <c:set var="s" value="${fn:split(k,' ') }"></c:set>
    <c:out value="${s[1]}"></c:out>
     -->
    
    <!-- Sql tags -->
    <sql:setDataSource
    var="con"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306"
    user="root"
    password =""
    />
    
    <sql:query dataSource="${con}" var="rs">select * from myportfolio.project</sql:query>
    
    <c:forEach var="data" items="${rs.rows}">
    <img style="height: 100px" alt="" src="images/myproject/${data.fileName}"><br>
    sn: ${data.sno}<br>
    fileName: ${data.fileName}<br>
    
    <!-- Data Data -->
    <form action="Project" method="post">
    <input type="hidden" name="check" value="deleteProject">
     <input type="hidden" name="sno" value="${data.sno}">
     <input type="hidden" name="fileName" value="${data.fileName}">
     <button>Delete</button>
    </form>
    </c:forEach><br><br>
    
    <button><a href="admin.jsp"> Admin </a> </button>
</body>
</html>