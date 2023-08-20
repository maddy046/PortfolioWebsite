<%@page import="com.entity.LoginDetails"%>
<%@page import="com.dao.ReadDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	 <% 
         String value=(String)session.getAttribute("msg");
         if(value!=null)
         {
    %>
    
    <h2 style="color: blue; text-align:center;"><% out.print(value);   %></h2>
    
       <%} 
        session.removeAttribute("msg");
       %>
       
       <%
       		ReadDaoImp r=new ReadDaoImp();
       		LoginDetails l=r.getLoginDetails();
       %>
       
       <!-- auto fill -->
       <form action="ChangeCredentials" method="post">
       	<input type="text" value="<%=l.getUserId()%>" name="userId"><br>
       	<input type="text" value="<%=l.getPassword() %>" name="password"><br>
       	<button>Update</button>
       </form>
       
      <br><br><br>
      <button><a href="admin.jsp">Home</a></button>
</body>
</html>