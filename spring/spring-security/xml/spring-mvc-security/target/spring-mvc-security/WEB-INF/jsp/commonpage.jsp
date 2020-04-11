<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Common Page</title>
</head>
<body>
	<h1>Common Page</h1>
	<p>Everyone has access to this page.</p>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
		ac velit et ante laoreet eleifend. Donec vitae augue nec sem
		condimentum varius.</p>
	<form id="logout" action="../auth/logout" method="post">
		<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
	</form>
</body>
</html>