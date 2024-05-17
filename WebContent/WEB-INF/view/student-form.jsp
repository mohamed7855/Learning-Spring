<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Form</title>
	<style>
		.error{
			color: red;
		}
	</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		<label for="fName">First Name (*)</label>
		<form:input id="fName" name="fName" path="firstName" />
		<form:errors path="firstName" cssClass="error"></form:errors>
		<br><br>
		<label for="lName">Last Name (*)</label>
		<form:input id="lName" name="lName" path="lastName" />
		<form:errors path="lastName" cssClass="error"></form:errors>
		<br><br>
		
		
		
		<button type="submit">Submit</button>
	</form:form>

</body>
</html>