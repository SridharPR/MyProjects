<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<link type = "text/css" rel = "stylesheet" href = "css/home.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marks Upload</title>
</head>
<body class="gradientbody">
<div class = "resultdiv">
		<div class = "sidediv" style = "float:right">
			<div class = "login">
				<a href="Login.jsp" class = "loginbutton" >Logout</a>
			</div>
		</div>	
		<center><img src = "image/swamiji.jpeg" alt="" width="8%" height= "8%" style = "margin:8px 0px 0px 24px" /></center>
<h3><i>Uploading Marks . . .</i></h3>
<form action="MarksInt.jsp" method="post">
<select name="sname">
		<%
			if(request.getAttribute("stud_names_list")!=null)
				{
					ArrayList<String> sb =(ArrayList<String>)request.getAttribute("stud_names_list");
					if(sb.size()>0)
					{
						for(int i=0;i<sb.size();i++)
						{
							out.println("<option>"+sb.get(i)+"</option>");
							out.println("<br/>");
						}
					}
					else
					{
						out.println("<h5> Currently No Student Details found . . . ! ! </h5>");
					}
				}
		%>
</select>
<h4><span style="color: black; padding-left:7.5cm;">NAME : <span style="color: black; padding-left: 2.1cm;"><input type="text" name="inputname" "20" maxlength="50" value="<%= request.getParameter("inputname")==null?"":request.getParameter("inputname") %>" title="Name of Student" /></span></span></h4>
<h4><span style="color: black; padding-left:7.5cm;">SCS21 : <span style="color: black; padding-left: 2.2cm;"><input type="text" name="marks1" "20" maxlength="50" value="<%= request.getParameter("marks1")==null?"":request.getParameter("marks1") %>" title="SCS21 - Marks" /></span></span></h4>
<h4><span style="color: black; padding-left:7.5cm;">SCS22 : <span style="color: black; padding-left: 2.2cm;"><input type="text" name="marks2" size="20" maxlength="50" value="<%= request.getParameter("marks2")==null?"":request.getParameter("marks2") %>" title="SCS22 - Marks" /></span></span></h4>
<h4><span style="color: black; padding-left:7.5cm;">SCS231 : <span style="color: black; padding-left: 2.0cm;"><input type="text" name="marks3" "20" maxlength="50" value="<%= request.getParameter("marks3")==null?"":request.getParameter("marks3") %>" title="SCS21 - Marks" /></span></span></h4>
<h4><span style="color: black; padding-left:7.5cm;">SCS243 : <span style="color: black; padding-left: 2cm;"><input type="text" name="marks4" "20" maxlength="50" value="<%= request.getParameter("marks4")==null?"":request.getParameter("marks4") %>" title="SCS21 - Marks" /></span></span></h4>
<h4><span style="color: black; padding-left:7.5cm;">SCS253 : <span style="color: black; padding-left: 2.0cm;"><input type="text" name="marks5" "20" maxlength="50" value="<%= request.getParameter("marks5")==null?"":request.getParameter("marks5") %>" title="SCS21 - Marks" /></span></span></h4> 
<span style="color: black; padding-left: 12.6cm;"><input type="submit" value="Upload"/></span></span></span></h4>
</form>
<%
	if((request.getAttribute("en")!=null)&&(request.getAttribute("cn")!=null))
		{
			out.println("<h4>Oops . . . ! ! Error . , DATABASE - Runtime Exception is avoided by Finite Automata..<h4>");
			out.println("<h4> </h4>"+request.getAttribute("en"));
			out.println("<h4> </h4>"+request.getAttribute("cn"));
			
		}
%>
</div>
</body>
</html>
