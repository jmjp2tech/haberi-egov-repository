<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Register</title>

	<script type="text/javascript" src="../js/core/jquery.2.1.0.js"></script>
	<script type="text/javascript" src="../js/core/jquery.json-2.4.min.js"></script>
	<script type="text/javascript" src="../js/egov/user_login.js"></script>
	
</head>
<body>
	<form id="user_register_form">
		<label for="username">Username: </label> 
		<input type="text" id="username" name="username" /><br /> 
		
		<label for="password">Password:</label>
		<input type="text" id="password" name="password" /><br /> 
		
		<br /> 
		<input type="button" id="submit_login_form" value="Logint" />

	</form>
</body>
</html>