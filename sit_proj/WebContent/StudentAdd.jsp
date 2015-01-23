<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/home.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
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
		<br />
		<h3>
			<i>Plese Enter Below Details of Student . . .</i>
		</h3>
		<br />
		<form action="RegInt.jsp" method="post">
			<h4>
				<span style="color: black; padding-left: 7.5cm;">Name : <span
					style="color: black; padding-left: 2.2cm;"><input
						type="text" name="reguname" "20" maxlength="50"
						value="<%=request.getParameter("reguname") == null ? "" : request
					.getParameter("reguname")%>"
						title="Name" /></span></span>
			</h4>
			<h4>
				<span style="color: black; padding-left: 7.5cm;">USN : <span
					style="color: black; padding-left: 2.4cm;"><input
						type="text" name="regemail" size="20" maxlength="50"
						value="<%=request.getParameter("regemail") == null ? "" : request
					.getParameter("regemail")%>"
						title="Email-ID" /></span></span>
			</h4>
			<h4>
				<span style="color: black; padding-left: 7.5cm;">Password : <span
					style="color: black; padding-left: 1.6cm;"><input
						type="text" name="regpass" "20" maxlength="50"
						value="<%=request.getParameter("regpass") == null ? "" : request
					.getParameter("regpass")%>"
						title="Password" /></span></span>
			</h4>
			<h4>
				<span style="color: black; padding-left: 7.5cm;">Branch : <span
					style="color: black; padding-left: 2cm;"><input type="text"
						name="regbranch" "20" maxlength="50"
						value="<%=request.getParameter("regbranch") == null ? "" : request
					.getParameter("regbranch")%>"
						title="Branch" /></span></span>
			</h4>
			<h4>
				<span style="color: black; padding-left: 7.5cm;">Date of
					Birth : <span style="color: black; padding-left: 1cm;"><input
						type="text" name="regdateofbirth" "20" maxlength="50"
						value="<%=request.getParameter("regdateofbirth") == null ? ""
					: request.getParameter("regdateofbirth")%>"
						title="Date of Birth" /></span>
				</span>
			</h4>

			<h4>
				<span style="color: black; padding-left: 8cm;"><span
					style="color: black; padding-left: 4.2cm;"><input
						type="submit" size="12" value="Submit . ." /></span></span>
			</h4>
			<br /> <br />
		</form>
	</div>
</body>
</html>
