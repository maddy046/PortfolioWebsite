<%@page import="com.entity.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ReadDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>

<title>Read All Message and operation in field's</title>
</head>
<body>
	<h1 style= "text-align: center; color: brown">All Messages Section</h1><br>

	<hr><br>
	
	 <% 
         String value=(String)session.getAttribute("msg");
         if(value!=null)
         {
    %>
    
    <h2 style="color: blue; text-align:center;"><% out.print(value);   %></h2>
    
       <%} 
        session.removeAttribute("msg");
       %>
	
	<table>
		<thead>
		<tr>	 
			<th>Sno</th>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
			<th>Deleted Fields</th>
		</tr>
		</thead>
		<tbody>
		<%
		ReadDaoImp r = new ReadDaoImp();
		ArrayList<Message> al = r.readAllMessage();
		for(Message m: al)
		{
	%>	
		<tr> 
	
			<th><%= m.getSno() %></th>
			<th><%= m.getName() %></th>
			<th><%= m.getEmail() %></th>
			<th><%=m.getMessage() %></th>
			
			<th><form action="DeleteMessage" method= "post">
				<input type="hidden" value=<%= m.getSno()%> name="sno">
				<button style= "background-color: red;">Delete</button>
				</form>
			</th>
			<br>
			<br>
		</tbody>
	<% } %>
	</table>

	

	
	<br><br><br>
	<button><a href="admin.jsp">Home</a></button>
</body>
</html>