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
		<label for="country">Country</label>
		<form:select id="country" path="country">
			<!-- only need getter getCountryOptions -->
			<form:options items="${student.countryOptions}" />
			
			
			<!-- Another Solution Without countryOptions
			<form:option value="Egypt" label="Egypt" selected="selected" />
			<form:option value="USA" label="USA" />
			<form:option value="Algeria" label="Algeria" />
			<form:option value="Bahrin" label="Bahrin" />
			-->
		</form:select>
		<br><br>
		<button type="submit">Submit</button>
	</form:form>

</body>
</html>