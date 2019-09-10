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

body {
	background-color: #595959;
}
h5{
color:green;
}
h4{
color:red;
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
					<h2>CONFIRMATION PAGE</h2>
				</fieldset>
			</center>
			<form action="Confirm_allotement" method="post">
				<br> <br> <input type="hidden" name="status_code"
					value="confirm">
				<%
					if (request.getAttribute("count") != null) {
						if (request.getAttribute("count").toString().equals("[0]"))
							out.print("<h4>currently no new applicants are there</h4>");
						else
							out.print("<h5>allotement successful<br/>total " + request.getAttribute("count").toString().split("",3)[1] + " students bean alloted seats</h5>");
					}
				%>

				<input type="submit"
					value="Confirm to the final alloatments of seats">

				<h6>*note: by choosing this action can not be reversible</h6>
		</fieldset>
		</form>
		</fieldset>
	</center>

</body>
</html>