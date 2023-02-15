<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1 align="center"> Session Attribute</h1>
<hr/>

first Name : ${firstName }
<br/>
lastName : ${lastName}
<br/>
Location : ${Location}
<br/>
<h1>------------------------------------------------------------</h1>

first name value fatching from request scope : ${requestScope.firstName}
<br/>
Second name value fatching from session scope : ${sessionScope.firstName}
<br/>
<a href="/love_calculator/${url}">next/${url}</a>


</body>
</html>