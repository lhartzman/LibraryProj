<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
  <title>User Admin</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/js/jquery-ui-1.10.2-custom/css/ui-lightness/jquery-ui-1.10.2.custom.css" />
  <script>
  $(function() {
    $( document ).tooltip();
  });
  </script>
  <style>
  label {
    display: inline-block;
    width: 5em;
  }
  </style>
	
</head>
<body>
<h1>
	User Admin  
</h1>


<div id="user" style="width=45; font-size=80%; text-align-center">
<a href="/library/users/adduser" title="Add User"><img src="/library/resources/images/user_control.png" height=45 width=45 alt="Add User" style="padding-bottom:0.5em;" ></a>
<br><b>Add User</b></div>
<br><br>
<div id="all_users" style="width=45; font-size=80%; text-align-center">
<a href="/library/users/all" title="See All Users"><img src="/library/resources/images/abstract_people.png" height=45 width=45 alt="See All Users" style="padding-bottom:0.5em;"></a>
<br><b>See All Users</b></div>
</body>
</html>
