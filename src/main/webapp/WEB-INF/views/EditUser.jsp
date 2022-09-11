<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EditUser</h2>
<%-- <s:form action="updateuser" method="post" modelAttribute="user">
	FirstName : <input path="firstName" value="${user.firstName }" />
	LastName : <input path="lastName"  value="${user.lastName }" /><br><br>
	
	<input type="hidden" name="userId" value="${user.userid}"/>
	
		<input type="submit" value="Update"/>
</s:form> --%>

<form action="updateuser" method="post">
	FirstName : <input type="text" name="firstName" value="${user.firstName }" /><br><Br>
	LastName : <input type="text" name="lastName" value="${user.lastName }" /><br><br>
	
	<input type="hidden" name="userid" value="${user.userid}"/>
	
		<input type="submit" value="Update"/>
</form>

</body>
</html>