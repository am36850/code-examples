<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Logged in users: Session Registry</title>
</head>
<body>
	<h1>Logged-in Users</h1>
	<table>
		<thead>
			<tr>
				<td style="width: 100">User name</td>
				<td style="width: 150">Authorities</td>
				<td style="width: 170">IsAccountNonExpired</td>
				<td style="width: 190">IsCredentialsNonExpired</td>
				<td style="width: 150">IsAccountNonLocked</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.authorities}" /></td>
					<td><c:out value="${user.accountNonExpired}" /></td>
					<td><c:out value="${user.credentialsNonExpired}" /></td>
					<td><c:out value="${user.accountNonLocked}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Total users: ${total}</p>
</body>
</html>