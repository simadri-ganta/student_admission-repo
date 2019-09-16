<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#id1 {
	align: center;
	width: 300px;
	height: 300px;
	padding: 90px;
	border: 1px solid black;
	background-color: lightgrey;
}

#id2 {
	border: 2px solid white;
	color: white;
	background-color: grey;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

body {
	background-color: #595959;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

tr:nth-child(odd) {
	background-color: #F3F5D5;
}

th {
	background-color: #BBBE6B;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<fieldset id="id1">
			<center>
				<fieldset id="id2">
					<h2>current status</h2>
				</fieldset>
			</center>
			<table>
				<tr>
					<td>Applcations received</td>
					<td><%=request.getSession().getAttribute("registered")%></td>
				</tr>

				<tr>
					<td>last Date for the applications review</td>
					<td>null</td>
				</tr>

				<tr>
					<td>Board of undertaking</td>
					<td>SSC,CBSE</td>
				</tr>

				<tr>
					<td>Admissions Status</td>
					<td>undergoing</td>
				</tr>

				<tr>
					<td>Total seats in avai</td>
					<td>25</td>
				</tr>

				<tr>
					<td>available seats</td>
					<td><%=(25 - Integer.parseInt(request.getSession().getAttribute("selected").toString()))%></td>
				</tr>

				<tr>
					<td>academics staring date</td>
					<td>08/12/2020</td>
				</tr>

			</table>




		</fieldset>
		</fieldset>
	</center>
</body>
</html>