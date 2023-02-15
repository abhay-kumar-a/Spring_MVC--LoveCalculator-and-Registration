<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Spring form library -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">

<title>Love Registration</title>

<!-- CSS style -->

<style type="text/css">
.error {
color: red ;
position: fixed;
text-align: left;
margin-left: 15px;
font-size: 11px;
}
</style>

<script type="text/javascript">


//document.getElementById("un") --->it will give whole input text field ---><input id="un" name="userName" type="text" value="">
// but i want only value from this text field. so i will use .vaue means
//document.getElementById("un").value  --- this will return actule value of text field;
function userCriteria() 
{
	 var un = document.getElementById("un").value;
	 var len = un.length;
	 
	 var cn = document.getElementById("cn").value;
	 var m1= cn.lenght;
	 if(len<3 )
		 {
			 
		 alert("please enter at least 3 character")
		 return false;
		 }
	 else if(cn.length<3)
		 {
		 alert("please enter at least 3 character")
		 return false;
		 }
	 
	 else 
		 return true;
	}
</script>
</head>
<body>
 

<!-- Normal HTML form -->
<!-- 
<div align="center">
<h1>Love Calculator</h1>
<form action="processForm" method="get">
<label for="name">Your Name : </label> 
<input type= "text" id=name name="userName"><br></br>
<label for="last">Crush Name : </label> 
<input type="text" id="last" name="crushName"><br></br>

<input type="checkbox" id="check" name= "check"> I am agreeing that this is fun
<br></br>
<input type="submit" value = "calculate">
</form>
</div>

-->
<!-- using from by spring form library   -->


<h1 align ="center"> Love Calculator</h1>

<div align="center" >
<form:form action="processForm" method="get" modelAttribute="userInfo" onsubmit="userCriteria() ">


 <label for="un">Your Name : </label> 
<form:input id="un" path="userName"/>
<form:errors path="userName" cssClass="error" />
<br></br>


<label for="cn">Crush Name : </label> 
<form:input id="cn" path="crushName"/>
<form:errors path="crushName" cssClass="error" />
<br></br>
<br></br>

<form:checkbox path="agree"/> 
 I am agreeing that this is fun.
<form:errors path="agree" cssClass="error" />

<br></br>
<input type="submit" value = "calculate">
</form:form>
</div>

</body>
</html>