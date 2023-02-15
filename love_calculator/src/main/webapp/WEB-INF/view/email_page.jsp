<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>email page</title>
</head>
<body>
<h3> Hi ${userInfo.userName} <br>
send result to your email
</h3>
<br/>



<form:form  action="/love_calculator/email_response" method="get"  modelAttribute="emailDTO" >
<label>your email id: </label>
<form:input path="email" />
<input type="submit" value="send">

</form:form>
</body>
</html>