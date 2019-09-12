<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.Jntu.sas.beans.Selectedstudents"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
}

td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 20px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

tr:nth-child(odd) {
	background-color: #F3F5D5;
}

a {
	color: red;
}

body {
	background-color: #595959;
}
</style>
</head>
<body>
	<%
		if (request.getAttribute("details") != null) {

		List<Selectedstudents> list = (List<Selectedstudents>) request.getAttribute("details");
		Iterator<Selectedstudents> list1 = list.iterator();
		out.print("<table>");
		out.print("<tr><th>Name</th>");
		out.print("<th>Board</th>");
		out.print("<th>Total marks</th>");
		out.print("<th>GPA</th>");
		out.print("<th>Percenatge</th>");
		out.print("<th>School</th>");
		out.print("<th>Department</th>");
		out.print("<th>Alloted department</th>");
		out.print("<th>college name</th>");
		out.print("<th>college code</th>");
		out.print("<th>applied date</th></tr>");
		while (list1.hasNext()) {
			Map<String, String> current = (Map) list1.next();

			out.print("<tr><td>" + current.toString().split(",")[0].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[1].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[2].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[3].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[4].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[5].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[6].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[7].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[8].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[9].toString().split("=")[1] + "</td>");
			out.print("<td>" + current.toString().split(",")[10].toString().split("=")[1] + "</td></tr>");

		}
		out.print("</table>");
			}
	%>
</body>
</html>