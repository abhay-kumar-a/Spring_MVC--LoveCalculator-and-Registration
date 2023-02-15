<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h1>Your Registration is Successful</h1>
<p></p>
<h2>The details enter by you are: </h2>
   Name: ${userInfo.name} <br/>
   Age : ${userInfo.age} <br/>
   User Name : ${userInfo.userName} <br/>
   Password : ${userInfo.password}  <br/>
   Country : ${userInfo.country} <br/>
   
   Hobbies :
   
   <c:forEach var = "hobb" items = "${userInfo.hobby}" >
    <c:out value="${hobb}"/>,
   </c:forEach>

    <br/>
   Gender : ${userInfo.gender}
   
   <br></br>
   <h1>Communication</h1>
   
   Email : ${userInfo.communication.email} <br/>
   Phone : ${userInfo.communication.phone}
</body>
</html>