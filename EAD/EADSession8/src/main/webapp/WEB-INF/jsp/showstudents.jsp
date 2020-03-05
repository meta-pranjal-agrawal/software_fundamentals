<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Student</title>
</head>
<body>
<table border="2px">
<thead>
<tr>

<th>First name</th>
<th>Last name</th>
<th>Father's name</th>
<th>email</th>
<th>age</th>
<th>class</th>
</tr>
</thead>
<tbody>
<c:forEach items="${students}" var="student">
<tr>
<td>${student.fName}</td>
<td>${student.lName}</td>
<td>${student.fatherName}</td>
<td>${student.email}</td>
<td>${student.age}</td>
<td>${student.classNumber}</td>
</c:forEach>

</tbody> 

</table>

</body>
</html>