<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>vinit</h1>
<s:form action="saveuser" method="post" modelAttribute="user">

fName:<s:input path="firstName"/>
<s:errors path="firstName"></s:errors>
lName:<s:input path="lastName"/>
<s:errors path="lastName"></s:errors>
email<s:input path="email"/>
<s:errors path="email"></s:errors>
gender: Male<s:radiobutton path="gender" value="male"/>
            Female<s:radiobutton path="gender" value="female"/>
            
password<s:password path="password" />
<s:errors path="password"></s:errors>
<input type="submit" value="signup">

</s:form>
</body>
</html>