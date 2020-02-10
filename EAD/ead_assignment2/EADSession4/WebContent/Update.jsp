<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*,com.connection.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<% 
String fullName="";
String gender="";
String email="";
String contactNumber="";
String organization="";
try
{
	Connection con = ConnectionUtility.getConnection();
	Statement stmt = (Statement) con.createStatement();
	
	String id= ""+session .getAttribute("empId");
	String query= "select * from employees where EmployeeID='"+id+"'";
	ResultSet rs =stmt.executeQuery(query);
	
	
		rs.next();

		fullName = rs.getString("FullName");
		gender = rs.getString("Gender");
		email = rs.getString("Email");
		contactNumber = rs.getString("ContactNumber");
		organization = rs.getString("Organization");
 

}
catch(Exception e)
{
	e.printStackTrace();
}

%>
<form action=UpdateTable method=post>
						<input type=text name="fullname" value=<%=fullName%>>
						 <input type=text name="gender" value=<%= gender%>> 
						 <input type=text name="email" value=<%=email%>>
						 <input type=text name="contactNumber" value=<%=contactNumber %>>
						<input type=text name="organization" value=<%=organization%>>
					<input type=submit value=update></form>
<%


%>
</body>
</html>