

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class UpdateTable
 */
@WebServlet("/UpdateTable")
public class UpdateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
			Connection con = ConnectionUtility.getConnection();
			Statement stmt = (Statement) con.createStatement();
			String fName=request.getParameter("firstname");
			String lastName=request.getParameter("lastname");
			String email=request.getParameter("email");
			String fatherName=request.getParameter("fathername");
			int classNumber=Integer.parseInt(request.getParameter("class"));
			int age=Integer.parseInt(request.getParameter("age"));
			int id=Integer.parseInt(request.getParameter("id"));
			
			String query="update students set First_Name='"+fName+"',Last_Name='"+lastName+"',EMail='"+email+"',Fathers_Name='"+fatherName
						+"',Class='"+classNumber+"',Age='"+age+"'where STUDENT_ID='"+id+"'";
			
			stmt.executeUpdate(query);
			
			response.sendRedirect("ShowStudent?");
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
