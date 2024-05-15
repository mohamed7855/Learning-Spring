<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- For Loop On Array OperatingSystem [] -->
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation</title>
</head>
<body>
	<h1>Hello ${student.firstName} ${student.lastName}</h1>
	<h2>Country ${student.country}</h2>
	<h2>Gender ${student.gender}</h2>
	<h2>OperatingSystems 
		<ul>
			<c:forEach var="item" items="${student.operatingSystems}">
	  			<li>${item}</li>
			</c:forEach>
		</ul>
	</h2>
</body>
</html>