<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/home.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Student</title>
</head>
<body class="gradientbody">
	<div class="resultdiv">

		<div class="sidediv" style="float: right">
			<div class="login">
				<a href="Login.jsp" class="loginbutton">Logout</a>
			</div>
		</div>
		<center>
			<img src="image/swamiji.jpeg" alt="" width="14%" height="14%"
				style="margin: 8px 0px 0px 24px" />
		</center>
		<br /> <br />
		<h3>
			<i>Please choose a Student name to be deleted . . .</i>
		</h3>
		<form action="Load.do" method="post">
			<select name="studname">
				<%
					if (request.getAttribute("stud_names_list") != null) {
						ArrayList<String> sb = (ArrayList<String>) request
								.getAttribute("stud_names_list");
						if (sb.size() > 0) {
							for (int i = 0; i < sb.size(); i++) {
								out.println("<option>" + sb.get(i) + "</option>");
								out.println("<br/>");
							}
						} else {
							out.println("<h5> Currently No Student Details found . . . ! ! </h5>");
						}
					}
				%>
			</select> <span style="color: black; padding-left: 1cm;"><input
				type="submit" value="Delete" /></span></span></span>
			</h4>
		</form>
	</div>
</body>
</html>
