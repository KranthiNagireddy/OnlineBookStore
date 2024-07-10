<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Home page for Online Book Store </title>
	<style>
		h1 
		{
			position: absolute;
			color  : green;
			border : 3px dotted purple; 
			left    :300px;
		}
		
		#d
		{
			position: absolute;
			top     : 150px;
			left    : 300px;
			color 	: #FFFFFF;
			//background-color :  orange;
			//border : 2px double red; 
		}
		
		body
		{
			background-color :  orange;
		}
		
	</style>
</head>
<body>
	<h1> Home page for Online Book Store </h1>
	<br/><br/> 
	<div id="d"> 
			<h3> Welcome to Online Book Store </h3> 
			<h4>	<a href="register.jsp">	Register </a> </h4>
			<h4>	<a href="VerifyRegisStatus.jsp"> Verify	Registration Status </a> </h4>
			<h4>	<a href="login.jsp">	Login 	 </a> </h4>
	</div>
		 
</body>
</html>