<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#f1 {
	background-color: #0b3f4f;
	height: 400px;
	width: 300px;
	padding: 20px;
}

body {
	background-color: #a1afb4;
	color: white;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset id="f1">
		<form action="status_check" method="post">
			<table>


				<tr>
					<input type="hidden" name="status_code" value="student_status">
					enter details here
					<td>UserId</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"></td>
				</tr>
				</form>
			</table>
			<%
				if (request.getAttribute("status") != null) {
					switch ((String) request.getAttribute("status")) {
					case "invalid_user":
						out.print("no user available");
						break;
					case "wrong_pass":
						out.print("no user available");
						break;
					case "accepted":
						out.print("ur application is accepted");
						break;
					case "pending":
						out.print("ur application is still pending you need to wait till final allotment");
						break;
					case "rejected":
						out.print("ur application is rejecpted");
						out.print("you can apply for your second choice of college that is"
								+ request.getAttribute("choice2"));
						String change = (String) request.getAttribute("name");
						String url = "changeapplication/" + change + "/" + request.getAttribute("choice2") + "/";
						System.out.println(url);
						out.print("<a href=" + (char) 34 + url + (char) 34 + ">click here for apply fro second choi e</a>");
						break;
					case "wrong_fromat":
						out.print("please enter correct details in correct format ");
						break;
					default:
						out.print("your not allowed");
					}
				}
			%>
		
	</fieldset>
</body>
</html>