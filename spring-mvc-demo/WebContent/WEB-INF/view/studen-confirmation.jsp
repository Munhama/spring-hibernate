<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>

	Student: ${student.firstName} ${student.lastName}
	
	<br></br>
	
	Your Country: ${student.country}
	
	<br></br>
	
	Your Favorite Language: ${student.favoriteLanguage}
	
	<br></br>
	
	Operating System:
	
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
	
</body>
</html>