<%@page import="model.DBConnectionOBS"%>
<%@page import="java.sql.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	 pageEncoding="ISO-8859-1" %> 
    	   
<!DOCTYPE html>
<html> <head> <title>View the Registration Details</title> </head>
<body>

	<% 
	 Connection Con = null;
	 response.setContentType("text/html");	 
	 PrintWriter out1 = response.getWriter();
	 
	try 
	{
		Con = DBConnectionOBS.cc();
		String 				 q      = "select * from userlogin";
		PreparedStatement   Pstobj  =  Con.prepareStatement(q);		 
			
		ResultSet RS =  Pstobj.executeQuery();
		
		out1.println("<table width='60%' border='2'>");
		out1.println("<tr> <th>user ID  </th><td>User Name </td>");
		out1.println("<td>User Role </td><td> Registration Status</td></tr>");
		 
		while (RS.next())
		{ 
			out1.println("<tr> <td> " + RS.getLong(1));			 
			out1.println(" <td> " + RS.getString(2));
			out1.println(" <td> " + RS.getString(3));
			out1.println(" <td> " + RS.getString(5));
			out1.println("</tr>"); 
		}
		out1.println("</table>");  
	}
	catch(Exception e)	{ out1.println(e);	}
	%>
	<a href="index.jsp"> Home Page</a>  
</body>
</html>