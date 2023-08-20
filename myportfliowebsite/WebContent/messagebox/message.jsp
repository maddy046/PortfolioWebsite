	
	 <% 
         String value=(String)session.getAttribute("msg");
         if(value!=null)
         {
    %>
    
    <h2 style="color: blue; text-align:center;"><% out.print(value);   %></h2>
    
       <%} 
        session.removeAttribute("msg");
       %>