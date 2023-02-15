<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.s
{
color :blue;
}
</style>
<meta charset="ISO-8859-1">
<title>Bill Details</title>
</head>
<body>
<h1>Bill Details</h1>

Card Number : <span class="s">${bill.cardNumber} </span> <br/>
Amount :<span class="s"> ${bill.amount} </span><br/>
Currency : <span class="s">${bill.currency} </span> <br/>
Date :<span class="s"> ${bill.date}</span>


</body>
</html>