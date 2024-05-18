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
		<label for="age">Age (*)</label>
		<form:input id="age" name="age" path="age" />
		<form:errors path="age" cssClass="error"></form:errors>
		<br><br>
		<label for="code">postalCode (*)</label>
		<form:input id="code" name="age" path="postalCode" />
		<form:errors path="postalCode" cssClass="error"></form:errors>
		<br><br>
		<label for="subject">Subject Code</label>
		<form:input id="subject" name="subject" path="subjectCode" />
		<form:errors path="subjectCode" cssClass="error"></form:errors>
		<br><br>
		
		
		<button type="submit">Submit</button>
	</form:form>

</body>
</html>