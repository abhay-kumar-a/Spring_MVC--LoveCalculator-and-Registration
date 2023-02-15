<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error
{
 color: red;
 position: fixed;
 margin-left: 25;
 text-align : left;
 font-size: 11px;
}

</style>

<meta charset="ISO-8859-1">
<title>Bill Home Page</title>
</head>
<body>

<h1 align="center">Bill Form</h1> <br></br>
<div align="center">
<form:form action="billProcess" method="get" modelAttribute ="bill">
<label>Credit Card : </label>
<form:input path ="cardNumber"/> 
<form:errors path="cardNumber" cssClass="error" /><br></br>


<label>Amount :</label>
<form:input path="amount"/> 
<form:errors path="amount" cssClass="error"  /><br></br>

<label>Currency : </label>
<form:input path= "currency"/> 
<form:errors path="currency"  cssClass="error" /><br></br>

<label>Date :</label>
<form:input type="date" path="date" /> 
<form:errors path="date" cssClass="error"  /> <br></br>

<input type="submit" value="PAYBILL" />

</form:form>

</div>

</body>



</html>