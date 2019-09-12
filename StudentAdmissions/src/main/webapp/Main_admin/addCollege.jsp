<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	background-color: #595959;
}

a {
	color: white;
}

#id2 {
	width: 200px;
	height: 55px;
	border: 2px solid white;
	color: white;
	background-color: grey;
}

body {
	background-image: url("sim1.jpeg");
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<fieldset id="id1">
		<center>
			<fieldset id="id2">
				<h3>Welcome to admin login page</h3>
			</fieldset>
		</center>





		<%
			if (request.getAttribute("status") != null) {
				if ((boolean) request.getAttribute("status")) {
					out.print("<h color=" + (char) 34 + "red" + (char) 34 + ">your succesfully registered</h>");
				} else {
					out.print("<h color=" + (char) 34 + "red" + (char) 34 + ">failed to register</h>");
				}

			}
		%>
		<form action="Addingcollege" method="post">
			<br>
			<br> <input type="hidden" name="status_code" value="new_college">

			College name <input type="text" name="name"><br>
			<br> College code <input type="text" name="code"><br>
			<br> College rank <input type="text" name="rank"><br>
			<br> <input type="submit"><br>
			<br>
			<br>
	</fieldset>
	</form>
	</fieldset>

</body>
</html>