<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
 
<body>
    <sql:setDataSource   var="myDS"     driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/ebookstore"
        user="root" password="#Daddy11" />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM userlogin;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Role</th>
                <th>Registration Status</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.uid}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.role}" /></td>
                    <td><c:out value="${user.reg_status}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>