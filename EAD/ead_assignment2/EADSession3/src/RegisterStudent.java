

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/RegisterStudent")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String eMail=request.getParameter("email");
			String fatherName=request.getParameter("fatherName");
			int classNumber=Integer.valueOf(request.getParameter("class"));
			int age=Integer.valueOf(request.getParameter("age"));
			Connection con = ConnectionUtility.getConnection();
		
			PreparedStatement stmt =con.prepareStatement("insert into students values(STUDENT_ID,?,?,?,?,?,?)");

			 stmt.setString(1, firstName);
			 stmt.setString(2, lastName);
			 stmt.setString(3, eMail);
			 stmt.setString(4, fatherName);	 
			 stmt.setInt(5, classNumber);
			 stmt.setInt(6, age);
			 stmt.executeUpdate();
//			 con.close();
			 PrintWriter out = response.getWriter();
			 out.println("<html><body><p> <center>You are registered </center></p></body></html>");
		}
		catch (SQLException e) 
		{
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
			out.println("<html><body><p> <a href=RegisterStudent.html> Try Again  </p></body></html>");
		}
	}

}
