<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
}

td{
  border: 1px solid #dddddd;
  text-align: left;
  padding: 15px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
tr:nth-child(odd) {
  background-color: #F3F5D5;
}
</style>
</head>
<body>
<%
switch((String)request.getAttribute("status")){
case "invalid_user":
	out.print("no user available");
case "wrong_pass":
	out.print("no user available");
case "accepted":
	
case "pending":
	
case "rejected":
	
	

}





%>


</body>
</html>