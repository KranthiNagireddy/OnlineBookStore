<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Approval </title>
</head>
<body>
	<h1>  Online Book Store </h1>
	<br/><br/>	
	<h5>Login Registration </h5>
	<br/><br/>
	<form name="lr"  id="lr"  method="post"  action="ApprovalLoginServlet.view">
	<table style="width:300px; border: 1px solid black">
		<tr> 
			<th>Enter user ID(Mobile Number) </th> 
			<td> <input type="number" name="uid" required min="1000000000" max="9999999999"/> </td>
		</tr>
		
		<tr> 
			<th>Enter user Name </th> 
			<td> <input type="text" name="uname" maxlength="20" /> </td>
		</tr>
		
		
		<tr> 
			<th>Select Your Role</th> 
			<td> 
				<select name="role">
					<option value="Customer"> Customer     </option>
					<option value="Admin">    Administrator </option>
				</select> 
			</td>
		</tr>
		
				
		<tr> 
			<th>Enter password </th> 
			<td> <input type="password" name="pwd" required  maxlength="10" /> </td>
		</tr>
		
		 
		<tr> 
			<th> <input type="submit" value="register"/> </th> 
			<th> <input type="reset" value="clear"/> </th>
		</tr>
		</table>
		</form>
</body>
</html>