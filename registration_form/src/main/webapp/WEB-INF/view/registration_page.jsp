<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- spring form tag library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Registration Page</title>
<style type="text/css">
   .error {
   color: red;
   margin-left: 15px;;
   position: fixed;
</style>
</head>
<body bgcolor="pink">
	<h2 align="center">Welcome to Registration</h2>

<div align="center">
<form:form action="user_details" method="get"  modelAttribute="userInfo">
Name : <form:input path="name" /> 
<form:errors  path="name" cssClass="error"/>
<br></br>

Age : <form:input path="age"/> 
      <form:errors  path="age" cssClass="error"/>
<br></br>


User Name : <form:input path="userName"/>
<form:errors path="userName" cssClass="error" />
<br></br>

Password : <form:input path="password"/> <br></br>

country : <form:select path="country">

			<form:option value="India" label="india" />
			<form:option value="USA" label="usa" />

		</form:select> <br></br>

hobby : 
<form:checkbox path="hobby" value="cricket" /> cricket
<form:checkbox path="hobby" value="reading" /> reading
<form:checkbox path="hobby" value="travel" /> travel
<form:checkbox path="hobby" value="programming" /> programming
<br></br>

Gender: 
<form:radiobutton path="gender" value="male" /> male
<form:radiobutton path="gender" value="female" /> female
<br></br>

<h2>Communication</h2>

<label>Email :</label>
<form:input path="communication.email"/>  <!-- here i am calling nested object form binding the data-->
<form:errors path="communication.email" cssClass="error" />
<br></br>

<label>Phone :</label>
<form:input path="communication.phone" />

 <br></br>
<input type="submit" value="registration" />
</form:form>


</div>


</body>
</html>
