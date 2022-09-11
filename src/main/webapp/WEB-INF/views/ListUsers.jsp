<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List all detail of signupuser</title>
</head>
<body>

	<table border="1">
		
		<tr>
			<th>fname</th>
			<th>lname</th>
			<th>email</th>
			<th>password</th>
			<th>gender</th>
			<th>usertype</th>
			<th>Action</th>
			
		</tr>

		<c:forEach items="${user}" var="add">
			
			<tr>
				<td>${add.firstName}</td>
				<td>${add.lastName}</td>
				<td>${add.email}</td>
				<td>${add.password}</td>
				<td>${add.gender}</td>
				<td>${add.usertype}</td>
				<td><a href="deletuser?userid=${add.userid}">delete</a>
				|
				<a href ="viewuser?userId=${add.userid}">view</a>
				| 
				<a href="edituser?userId=${add.userid}">Edit</a></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>