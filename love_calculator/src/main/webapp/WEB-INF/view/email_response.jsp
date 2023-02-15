<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email response page</title>
</head>
<body>

<h3>Hey <span style="color: sky">${userInfo.userName}</span></h3>

<div align="center">
<h2>Email successfully send to <span style="color: red">${emailDTO.email}</span>..</h2> 
</div>
 
</body>
</html>