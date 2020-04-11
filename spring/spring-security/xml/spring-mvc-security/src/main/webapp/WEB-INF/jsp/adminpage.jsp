<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<h1>Admin Page</h1>
	<p>Only admins have access to this page.</p>
	<p>Curabitur quis libero elit, dapibus iaculis nisl. Nullam quis
		velit eget odio adipiscing tristique non sed ligula. In auctor diam
		eget nisl condimentum laoreet..</p>
	<form id="logout" action="../auth/logout" method="post">
		<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
	</form>
</body>
</html>