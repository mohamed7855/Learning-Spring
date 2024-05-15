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
		<!-- only need getter getGenderOptions -->
		<form:radiobuttons path="gender" items="${student.genderOptions}" />
		
		
		<!-- Another Solution Without genderOptions
		<label for="Male">Male</label>
		<form:radiobutton id="Male" value="Male" path="gender" />
		<label for="Female">Female</label>
		<form:radiobutton id="Female" value="Female" path="gender" />
		-->	
		
			
		<br><br>
		<!-- only need getter getOSs -->
		<form:checkboxes path="operatingSystems" items="${student.OSs}" />
		
		
		<!-- Another Solution Without operatingSystems
		<label for="Linux">Linux</label>
		<form:checkbox id="Linux" path="operatingSystems" value="Linux" />
		<label for="Windows">"Windows"</label>
		<form:checkbox id="Windows" path="operatingSystems" value="Windows" />
		<label for="Mac">Mac</label>
		<form:checkbox id="Mac" path="operatingSystems" value="Mac" />
		<br><br>
		-->	
		<button type="submit">Submit</button>
	</form:form>

</body>
</html>