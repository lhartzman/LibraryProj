<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
<script type="text/javascript" language="JavaScript">
        function clickedButton()
        {
            window.location = '/library/users/admin'
        }
</script>
</head>
<body>
<h1>Add New User</h1>
<div id="container">
    <div id="formdiv">
        <form:form method="POST" action="newuser" modelAttribute="user">
            <table celllspacing="10">
                <tr>
                   <td><form:label path="firstname">First Name</form:label></td>
                   <td><form:input path="firstname" label=" First Name" type="text"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="lastname">Last Name</form:label></td>
                    <td><form:input path= "lastname" type="text"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email" type="text"></form:input></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add User"></td>
                    <td><input type="button" value="Cancel" onClick="clickedButton()" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
</body>
</html>