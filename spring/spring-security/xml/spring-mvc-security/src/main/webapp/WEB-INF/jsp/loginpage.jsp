<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
	<div id="login-error">${error}</div>
	<div id="login-error">${logout}</div>
	<div id="login-error">${sessionexpired}</div>
	<div id="login-error">${permittedAuthExceeds}</div>
	<form action="../processlogin" method="post">
		<p>
			<label for="username">Username:</label> <input id="username"
				name="username" type="text" />
		</p>
		<p>
			<label for="password">Password:</label> <input id="password"
				name="password" type="password" />
		</p>
		<input type="submit" value="Login" />
	</form>
</body>
</html>