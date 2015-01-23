<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="Stylesheet" type="text/css" href="Sri1.css" />
<link type="text/css" rel="stylesheet" href="css/home.css" />
<style>
html {
	width: 99%;
	height: 100%;
}
</style>
</head>
<body class="gradientbody">
	<div class="backg">
		<br /> <br /> <br /> <br /> <br />
		<h3>
			<span style="color: black; visibility: hidden;"><a
				href="Homepage.jsp"><p align="right" title="Home Page">Home</p></a></span>
		</h3>
		<br /> <br /> <br /> <br />
		<form action="LoginInt.jsp" method="post">
			<h4>
				<span style="color: black; padding-left: 50%;"><span
					style="color: black; padding-left: 0.3cm; width: 150px;"><input
						type="text" name="email" style="width: 200px" size="24"
						maxlength="50"
						value="<%=request.getParameter("errorMsg") == null ? "" : request
					.getParameter("email")%>"
						title="Username" /></span></span>
			</h4>
			<h4>
				<span style="color: black; padding-left: 50%; width: 150px;"><span
					style="color: black; padding-left: 0.3cm;"><input
						type="password" name="pass" size="24" style="width: 200px"
						maxlength="20"
						value="<%=request.getParameter("errorMsg") == null ? "" : request
					.getParameter("pass")%>"
						title="Password" /></span></span>
			</h4>
			<h4>
				<span style="color: black; padding-left: 40%;"><span
					style="color: black; padding-left: 7.3cm;"><input
						type="submit" size="12" value="Login" title="Login" /></span></span>
			</h4>
			<br /> <br />
			<%
				if (request.getAttribute("errorMsg") != null) {
					out.println("<h4>Oops . . . ! ! Error . , </h4>"
							+ request.getAttribute("errorMsg"));
				}
			%>
		</form>
		<h3>
			<span style="color: black; font-size: 13px;"><a
				href="Homepage.jsp"><p align="center" title="Home Page">Back
						to Home</p></a></span>
		</h3>
	</div>
</body>
</html>
