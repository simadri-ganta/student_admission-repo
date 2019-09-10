<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	background-color: #dddddd;
}

a {
	color: red;
}

body {
	background-image: url("sim.jpeg");
}
</style>
</head>
<body>
	<section>
	<table width="100%">
<tr><td>
		<table>
			<tr>
				<td><a href="reviewAppliaction" target="iframe_a">review</a></td></tr>
			
				<tr><td><a href="departmentwise" target="iframe_a">show departmentsr</a></td></tr>
				<tr><td><a href="top10" target="iframe_a">top students</a></td></tr>
			
				<tr><td><a href="confirmationpage" target="iframe_a">confirm allapplications</a></td>

			</tr>
		</table>
		</td>
		<td>
		<table>
			<iframe width="1000px" height=600px" src="reviewAppliaction" name="iframe_a"></iframe>
		</table>
		</td></tr>
</table>
	</section>
</body>
</html>