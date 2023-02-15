<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Adding reference  JSTL tag library -->
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
   <h1>Student Name is : ${first} ${last} </h1>
   
   <!-- Student name is get by JSP... -->
   <h1>Student name is get by JSP</h1>
   <h1>The student is confirmed : ${newStudent.firstName} ${newStudent.lastName} </h1>
   <h1>Country name is : ${newStudent.country}</h1>
   <br></br>
   <h1>Language is : ${newStudent.favoriteLanguage}</h1>
   <br></br>
   <h1>Operation Systems :</h1> <br/>
   
   <ul>
      <c:forEach var="temp" items = "${newStudent.operationSystem}">
        <li>${temp }</li>
        
        </c:forEach>
   </ul>
   
   
</body>
</html>