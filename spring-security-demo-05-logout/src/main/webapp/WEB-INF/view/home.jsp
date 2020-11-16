<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>

<html>
<head>
	<title>Home Page</title>
</head>

<body>
	<h2>Hello World!</h2>
	<hr>
	
	<p>
		Welcome!!!
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
	
</body>
</html>