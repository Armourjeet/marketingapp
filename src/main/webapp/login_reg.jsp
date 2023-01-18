<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h2>Login here...</h2>
<hr>
<pre>
<form action="verifylogin" method="post">
Username: <input type ="text" name="email"/> <br> <br> 
Password: <input type ="password" name="password"/><br>
<input type="submit" value="login"/>
</form>
</pre>
<%  if (request.getAttribute("error")!= null){ 
	out.println(request.getAttribute("error"));
}

%>
<%  if (request.getAttribute("msg")!= null){ 
	out.println(request.getAttribute("msg"));
}

%>
</body>
</html>