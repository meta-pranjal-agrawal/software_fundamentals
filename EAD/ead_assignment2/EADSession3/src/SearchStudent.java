

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String fName=request.getParameter("firstNameSearch");
			String lName=request.getParameter("lastNameSearch");
			Connection con=ConnectionUtility.getConnection();
			
			Statement stmt= con.createStatement();
			String query1= "Select * from students where First_Name='"+fName+"' and Last_Name='"+lName+"' Group By Class";
			
			ResultSet rs= stmt.executeQuery(query1);
			PrintWriter out= response.getWriter();
			
			out.println("<html><body><table border=1 width=50% height=50%>");  
	        out.println("<tr><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Email</th><th>Class</th><th>Age</th></tr>");  
	       
			
			while(rs.next())
			{
				String firstname = rs.getString("First_Name");
				String lastname=rs.getString("Last_Name");
				String email=rs.getString("EMail");
				String fatherName=rs.getString("Fathers_Name");
				String classnumber=rs.getString("Class");
				String age=rs.getString("Age");
				
				out.print("<tr><td>" + firstname +"</td><td>" + lastname+"</td><td>" + email +"</td><td>" + fatherName + "</td><td>" +classnumber +"</td><td>" +age+"</tr>");
				
			}
			 out.println("</table></body></html>"); 
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
