<%@page import="java.util.Map"%>
<%@page import="com.Jntu.sas.beans.Selectedstudents"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
	<h3>cse</h3>
	<%
		try {
		ArrayList<List<Selectedstudents>> list = (ArrayList<List<Selectedstudents>>) request.getAttribute("values");
		List<Selectedstudents> cse = list.get(0);
		List<Selectedstudents> ece = list.get(1);
		List<Selectedstudents> it = list.get(2);
		List<Selectedstudents> mech = list.get(3);
		System.out.println("1"+cse+"\n2"+ece+"\n3"+it+"\n4"+mech);
		
		Iterator<Selectedstudents> cseiter=cse.iterator();
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
		while(cseiter.hasNext()){
			Map<String,String> current=(Map)cseiter.next();
			
			out.print("<tr><td>"+current.toString().split(",")[0].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[1].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[2].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[3].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[4].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[5].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[6].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[7].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[8].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[9].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[10].toString().split("=")[1]+"</td></tr>");
			
		}out.print("</table>");
	%>
	</table>
<h3>ece</h3>
	<table>
		<%
			Iterator<Selectedstudents> eceiter=ece.iterator();
				out.print("<table>");
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
				while(eceiter.hasNext()){
			Map<String,String> current=(Map)eceiter.next();
			
			out.print("<tr><td>"+current.toString().split(",")[0].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[1].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[2].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[3].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[4].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[5].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[6].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[7].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[8].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[9].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[10].toString().split("=")[1]+"</td></tr>");
			
				}out.print("</table>");
		%>
	</table>
<h3>it</h3>

	<table>
		<%
			Iterator<Selectedstudents> ititer=it.iterator();
				out.print("<table>");
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
				while(ititer.hasNext()){
			Map<String,String> current=(Map)ititer.next();
			
			out.print("<tr><td>"+current.toString().split(",")[0].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[1].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[2].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[3].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[4].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[5].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[6].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[7].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[8].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[9].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[10].toString().split("=")[1]+"</td></tr>");
			
				}out.print("</table>");
		%>
	</table>

<h3>mech</h3>
	<table>
		<%
			Iterator<Selectedstudents> mechiter=mech.iterator();
				out.print("<table>");
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
				while(mechiter.hasNext()){
			Map<String,String> current=(Map)mechiter.next();
			
			out.print("<tr><td>"+current.toString().split(",")[0].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[1].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[2].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[3].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[4].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[5].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[6].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[7].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[8].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[9].toString().split("=")[1]+"</td>");
			out.print("<td>"+current.toString().split(",")[10].toString().split("=")[1]+"</td></tr>");
			out.print("</table>");
			
				}
		%>
	</table>


	<%

		} catch (Exception e) {

		}
	%>
</body>
</html>