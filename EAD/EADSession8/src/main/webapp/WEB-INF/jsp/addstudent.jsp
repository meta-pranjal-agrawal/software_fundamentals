<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<spring:url value="/addstudent" var="addstudent" />
<form:errors />
<form:form modelAttribute="student" action="${addstudent}"> 
<form:errors path="fName"/>
<form:input type="text" placeholder="First Name" path="fName"/><br><br>
<form:errors path="lName"/> 
<form:input type="text" placeholder="Last Name" path="lName"/><br><br>
<form:errors path="fatherName"/>
<form:input type="text" placeholder="Father's Name" path="fatherName"/><br><br>
<form:errors path="email"/>
<form:input type="text" placeholder="email" path="email"/><br><br>
<form:errors path="classNumber"/>
<form:input type="text" placeholder="class" path="classNumber"/><br><br>
<form:errors path="age"/>
<form:input type="text" placeholder="age" path="age"/><br><br>

<input type="submit" value="submit">
</form:form>
</body>
</html>