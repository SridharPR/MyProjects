<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<link type = "text/css" rel = "stylesheet" href = "css/home.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student View</title>
</head>
<body class = "gradientbody">
	<%
		
		List listOfData = (List)request.getAttribute("dataList");
		
	%>
	

	<div class = "resultdiv">
		
		<div class = "sidediv" style = "float:right">
			<div class = "login">
				<a href="Login.jsp" class = "loginbutton" >Logout</a>
			</div>
		</div>
		
				
	<%
		if(request.getAttribute("nannahesaru")!=null)
		{
			out.println("<pre><h2><i>"+"   Welcome...    "+   request.getAttribute("nannahesaru")+"</i></h2></pre>");
		}
	%>
		<center><img src = "image/swamiji.jpeg" alt="" width="14%" height= "14%" style = "margin:8px 0px 0px 24px" /></center>
		<div class = "labelcss1"><label class = "labelcss"></label></div><br/>
		<div style = "float:left">
			<h3 style = "color:#1F33FF;text-decoration:underline;margin-left:10%;font-size:12px;"> Student Profile</h3><br/>
			<div style="width:200px;float:left"><label class = "labelcss">Name	: </label></div>
			<div class = "labelcss1"><label class = "labelcss"> <%=listOfData.get(0) %></label></div><br/>

			<div style="width:200px;float:left""><label class = "labelcss">USN	: </label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(1) %></label></div><br/>

		 	<div style="width:200px;float:left""><label class = "labelcss">Branch :</label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(2) %></label></div><br/>

			<div style="width:200px;float:left""><label class = "labelcss">Date of Birth : </label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(3) %></label></div><br/><br/><br/>

			  
			<h3 style = "color:#1F33FF;text-decoration:underline;margin-left:10%;font-size:12px;"> Marks List</h3><br/>	
			<div style="width:200px;float:left""><label class = "labelcss">SCS21 : </label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(4) %></label></div><br/>

			<div style="width:200px;float:left""><label class = "labelcss">SCS22 : </label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(5) %></label></div><br/>
			
			<div style="width:200px;float:left""><label class = "labelcss">SCS231 : </label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(6) %></label></div><br/>

			<div style="width:200px;float:left""><label class = "labelcss">SCS243 : </label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(7) %></label></div><br/>
			
			<div style="width:200px;float:left""><label class = "labelcss">SCS253 : </label></div>
			<div class = "labelcss1"><label class = "labelcss"><%=listOfData.get(8) %></label></div><br/>

			
		</div>
		<!-- <div class="photo">
				<img ></img>
		</div> -->

	</div>

</body>
</html>
