<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>

	The customer: ${customer.firstName} ${customer.lastName}
	
	<br><br>
	
	Free Pass: ${customer.freePasses}

</body>

</html>