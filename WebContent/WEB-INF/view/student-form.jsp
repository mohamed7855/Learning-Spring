<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		<label for="fName">First Name</label>
		<form:input id="fName" name="fName" path="firstName" />
		<br><br>
		<label for="lName">Last Name</label>
		<form:input id="lName" name="lName" path="lastName" />
		<br><br>
		<button type="submit">Submit</button>
	</form:form>

</body>
</html>