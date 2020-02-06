
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Connection con = ConnectionUtility.getConnection();
			Statement stmt = (Statement) con.createStatement();
			String query = "Select * from students";

			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			PrintWriter out = response.getWriter();
			RequestDispatcher rd=request.getRequestDispatcher("Update");
			
			out.println("<html><body><table border=1 width=50% height=50%>");  
	        out.println("<tr><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Email</th><th>Class</th><th>Age</th><th>Update</th><tr>");  
	        while (rs.next())
	         {  
	               String id=rs.getString("STUDENT_ID");
	               String firstName = rs.getString("First_Name");
	               String lastName = rs.getString("Last_Name");
	               String email = rs.getString("EMail");
	               String fatherName = rs.getString("Fathers_Name");
	               int classNumber = Integer.parseInt(rs.getString("Class"));
	               int age = Integer.parseInt(rs.getString("Age"));  
	               out.println("<form action=Update method=post><input type=hidden name=id value='"+id+"'/><tr><td>" + firstName + "</td><td>" + lastName + "</td><td>" + fatherName +"</td><td>" + email +"</td><td>" + classNumber+"</td><td>" + age +"</td><td>"
	               		+ "<input type=submit value=update></form></td></tr>");
	        
	               
	          }  
	           out.println("</table></body></html>"); 
			
			
	

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}