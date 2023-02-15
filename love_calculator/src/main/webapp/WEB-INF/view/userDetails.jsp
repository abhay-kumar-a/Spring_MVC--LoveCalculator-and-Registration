<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>

<!-- Data Binding using @RequestParam -->
<!-- 
User Name is : ${userName} <br></br>
Crush Name is :  ${crushName}
 <br></br>
<!-- Data Getting using DTO -->
 <!--  
User Name is : ${user.userName}  <br></br>
Crush Name is : ${user.crushName}

 <br></br>
 -->
<!-- Data Getting @ModelAttribute and DTO object -->

User Name is : ${userInfo.userName}  <br></br>
Crush Name is : ${userInfo.crushName}


<h1>Love Calculator</h1>

The Love calculator predicts:  <br/>
${userInfo.userName} and ${userInfo.crushName} are:  <br/>
${predictResult}  <br/>


<br></br>



<a href ="/love_calculator/email_page">send result to email</a>
</body>
</html>