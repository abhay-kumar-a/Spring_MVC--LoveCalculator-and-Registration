<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- URL for JSP  For -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>

<!-- Make form in HTML -->
<form action="submit_form">
<label for="firstName">Student First_Name</label>
  <input type="text" id=firstName name=first>
  
  <br></br>
  <label for="lastName">Student last_Name</label>
  <input type ="text" id="lastName" name=last>
  <br></br>
  <input type ="submit" value="registration">
</form>

<br></br>

<!-- Making for using JSP -->
<form:form action="submit_form" modelAttribute="newStudent">
First Name :<form:input path ="firstName"/> <br></br>
Last Name : <form:input path="lastName"/> <br></br>
Country: <form:select path="country">
<form:option value="A" label="Astrelia"/>
<form:option value="B" label="Brazil"/>
<form:option value="C" label="Canada"/>
</form:select>
<br></br>

<!-- Adding radio Button -->
Java<form:radiobutton path="favoriteLanguage" value="java"/>
Python<form:radiobutton path="favoriteLanguage" value ="python"/>
Ruby<form:radiobutton path="favoriteLanguage" value ="Ruby"/>
<br></br>

<!-- Adding Check Box -->
Windows <form:checkbox path="operationSystem" value="Windows"/>
Linux <form:checkbox path="operationSystem" value="Windows"/>
Mac OS <form:checkbox path="operationSystem" value="Windows"/>
<input type="submit" value="Submit">
</form:form>


</body>
</html>