<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="message/errorpage.jsp" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edu Backend</title>
</head>
<body>

	<sql:setDataSource
    var="con"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306"
    user="root"
    password =""
    />
    
    <sql:update dataSource="${con}" var="row" > insert into myportfolio.edu(year,title,subtitle,description) values(?,?,?,?)
    	
    	<sql:param value="${param.year}"></sql:param>
    	<sql:param value="${param.title}"></sql:param>
    	<sql:param value="${param.subtitle}"></sql:param>
    	<sql:param value="${param.description}"></sql:param>
    </sql:update>
    
    <c:if test="${row==1}">
    	<c:set var="msg" value="Data inserted successfully" scope="session"></c:set>
    	<c:redirect url="addEdu.jsp"></c:redirect>
    </c:if>
    	<c:set var="msg" value="Something went wrong" scope="session"></c:set>
    	<c:redirect url="addEdu.jsp"></c:redirect>
</body>
</html>