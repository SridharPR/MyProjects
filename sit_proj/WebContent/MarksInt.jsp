<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marks Bean</title>
</head>
<body>
	<jsp:useBean id="up" class="cloud.sit.MarksBean" scope="request">
		<jsp:setProperty name="up" property="*" />
	</jsp:useBean>
	<jsp:forward page="/UpLoad.do"></jsp:forward>
</body>
</html>