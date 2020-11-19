<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
	
	<hr>
	
		<!-- Display username and role -->
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role: <security:authentication property="principal.authorities" />
		</p>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
	
</body>
</html>