<%@page import="org.springframework.http.MediaType"%>
<%@page import="org.springframework.web.client.RestTemplate"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
#id1 {
	align: center;
	width: 300px;
	height: 700px;
	padding: 90px;
	border: 1px solid black;
	background-color: lightgrey;
}

#id2 {
	width: 200px;
	height: 55px;
	border: 2px solid white;
	color: white;
	background-color: grey;
}

body {
	
}

td {
	padding: 10px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function ssc() {
		document.getElementById("id3").disabled = true;
	}
	function cbse() {
		document.getElementById("id3").disabled = false;
	}
</script>
</head>
<body>

	<center>
		<fieldset id="id1">
			<center>
				<fieldset id="id2">
					<h3>Welcome admission page</h3>
				</fieldset>
				<%
		if (request.getAttribute("status") != null) {
			if ((boolean) request.getAttribute("status")) {
				out.print("<h color=" + (char) 34 + "red" + (char) 34 + ">your succesfully registered</h>");
			} else {
				out.print("<h color=" + (char) 34 + "red" + (char) 34 + ">failed to register</h>");
			}

		}
	%>
			</center>
			<form action="New_applicant" method="GET">
				<br> <br>
				<table>
					<tr>
						<td>name</td>
						<td><input type="text" name="name"><br> <br>
					</tr>
					<tr>
						<td>Board type:</td>
						<td>ssc<input onclick="ssc()" type="radio" name="board"
							value="ssc"> cbse<input onclick="cbse()" type="radio"
							name="board" value="cbse"></td>
					</tr>
					<tr>
						<td>total marks</td>
						<td><input type="text" name="marks"></td>
					</tr>
					<tr>
						<td>gpa</td>
						<td><input id="id3" type="text" name="gpa"></td>
					</tr>
					<tr>
						<td>percentage</td>
						<td><input onchange="id77()" type="text" name="percentage"></td>
					</tr>
					<tr>
						<td>school</td>
						<td><input type="text" name="school"></td>
					</tr>
					<tr>
						<td>department choice</td>
						<td><select name="department">
								<option>select department</option>
								<option value="cse">Cse</option>
								<option value="ece">Ece</option>
								<option value="it">It</option>
								<option value="mech">Mech</option>
						</select></td>
					</tr>
					<%
						for (int i = 0; i < 2; i++) {
					%>
					<tr>
						<td>College choice<%
							out.print(i + 1);
						%></td>
						<td><select name="<%out.print("college_choice" + (i + 1));%>">
								<option>select college</option>
								<%
									RestTemplate template=new RestTemplate();
										ArrayList<String> list = template.getForObject("http://localhost:8087/getcollegelist/", ArrayList.class);
										Iterator<String> iterate = list.iterator();
										while (iterate.hasNext()) {

											out.print("<option value=" + (char) 34 + iterate.next() + (char) 34 + ">" + iterate.next()
													+ "</option>");
										}
								%>
						</select></td>
						<%
							}
						%>
					
					<tr>
						<td></td>
						<input type="hidden" name="status_code" value="newapplication">
						<td><input type="submit"></td>

					</tr>
				</table>
			</form><h6>*note: Once you apply, you can login[name as your userId(example abcd)] and password[board/gpa/board/percenatge(Example ssc/9.7/ssc/97)])<a href="application_status.jsp">click to check</a></h6>
		</fieldset>
	</center>

</body>
</html>