<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="manu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> create </title>
</head>
<body>
<h2> Create New Registration here...</h2>
<hr>
<form action="new" method ="post">
<pre>
Name <input type ="text" name ="name"/> <br>
City <input type ="text" name ="city"/><br>
Email <input type ="text" name ="email"/><br>
Mobile <input type ="text" name ="mobile"/><br>
<input type ="submit" value ="save"/>
</pre>
</form>
<%  if (request.getAttribute("msg")!= null){ 
	out.println(request.getAttribute("msg"));
}

%>
</body>
</html>