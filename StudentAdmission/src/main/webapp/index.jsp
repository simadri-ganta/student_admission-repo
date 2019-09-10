<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
#id1 {
	align: center;
	width: 300px;
	height: 400px;
	padding: 90px;
	border: 1px solid black;
	background-color: #595959;
}

a {
	color: white;
}
h4{

color:red;
}
#id2 {
	width: 200px;
	height: 55px;
	border: 2px solid white;
	color: white;
	background-color: grey;
}

body {
	background-image: url("sim.jpeg");
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
		<fieldset id="id1">
<% if(request.getAttribute("status")!=null)
{
	switch((String)request.getAttribute("status")){
		case "wrong_pass":
			out.print("<h4>password wrong</h4>");
			break;
		case "no_user":
			out.print("<h4>no user available</h4>");
			break;
		case "something_went_wrong":
			out.print("<h4>something went wrong</h4>");
			break;
		case "null":
			out.print("<h4>null pointer problems</h4>");
			break;
		case "please_values":
			out.print("<h4>please enter the values</h4>");
			break;
		default:
			break;
	}
	
}
%>

	
			<center>
				<fieldset id="id2">
					<h3>Welcome to admin login page</h3>
				</fieldset>
			</center>
			<form action="login_admin_home" method="post">
				<br>
				<br> <input type="hidden" name="status_code" value="admin1ogin">

				username <input type="text" name="name"><br>
				<br> password <input type="password" name="pass"><br>
				<br> <input type="submit"><br>
				<br>
				<br> <a href="newadmissionform">apply for new admission</a>
				<a href="application_status.jsp">check applcation status</a>
				
		</fieldset>
		</form>
		</fieldset>
	</center>

</body>
</html>