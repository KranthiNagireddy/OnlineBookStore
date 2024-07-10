<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="orange">
	<% 
		String ls = null;
		try
		{
			 ls = (String) request.getAttribute("LS");
			out.println(ls);
			if (ls==null)
			{
			 request.getRequestDispatcher("index.jsp").forward(request, response);			 
			}			 
		}
		catch(Exception e)
		{			
		}
	
	%>
	
	
</body>
</html>