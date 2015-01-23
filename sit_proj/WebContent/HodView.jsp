<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<link type = "text/css" rel = "stylesheet" href = "css/home.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cloud Application</title>
</head>
<body class="gradientbody">
<div class = "resultdiv">
		
		<div class = "sidediv" style = "float:right">
			<div class = "login">
				<a href="Login.jsp" class = "loginbutton" >Logout</a>
			</div>
		</div>
		
		<center><img src = "image/swamiji.jpeg" alt="" width="14%" height= "14%" style = "margin:8px 0px 0px 24px" /></center>

		<h4><span style="color: Blue; padding-left:1cm;"><a href="openStudentAddView.do" title="Click here to Add new Student to Cloud">Add Student</a></span></h4>
		<h4><span style="color: Blue; padding-left:1cm;"><a href="openStudentDeleteView.do" title="Click here to Delete Existing Student from Cloud">Delete Student</a></span></h4>
		<h4><span style="color: Blue; padding-left:1cm;"><a href="openStudentUploadView.do" title="Click here to Marks to Cloud">Upload Marks</a></span></h4>
		<br/><br/><br/>
		<%
			if(request.getAttribute("error")!=null)
			{
				out.println("<h4> Currently No Student Details found . . . ! !</h4>");
			}
		
		%>
		
		<%
			if(request.getAttribute("sucessdelete")!=null)
			{
				out.println("<h4> Student Details Successfully Deleted . . . ! !</h4>");
			
			}
		%>
		<%
			if(request.getAttribute("uploadsuccess")!=null)
			{
				out.println("<h4>Success . . . ! !</h4>"+request.getAttribute("uplooadsuccess"));
			}
		%>
		
		
</div>
</body>
</html>
