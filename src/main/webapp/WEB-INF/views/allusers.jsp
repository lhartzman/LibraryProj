<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script type="text/javascript" language="JavaScript">
        function allUsers()
        {
            window.location = '/library/users/adduser'
        }
        
        function goHome()
        {
        	window.location = '/library/users/admin'
        }
</script>
</head>
<body>
<h1>Users</h1>

<table style="border: 1px solid; width: 500px; text-align:center">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
            <c:url var='editURL' value='/users/edit?id=${user.id}' />
            <c:url var='deleteURL' value='/users/delete?id=${user.id}' />
            <tr>
                <td><c:out value="${user.firstname}" /></td>
                <td><c:out value="${user.lastname}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><a href="${editURL}">Edit</a></td>
                <td><a href="${deleteURL}">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<table> 
<tr>
<td><input type="button" value="Add User" onClick="allUsers()"></td>       
<td><input type="button" value="Home" onClick="goHome()"></td>
</tr>
</table>
</body>
</html>