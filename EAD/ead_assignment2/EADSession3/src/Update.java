

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection con = ConnectionUtility.getConnection();
			Statement stmt = (Statement) con.createStatement();
			String id=request.getParameter("id");
			String query = "Select * from students where STUDENT_ID='"+id+"'";
			ResultSet rs=stmt.executeQuery(query);
			PrintWriter out = response.getWriter();
			out.print("<html><body>First Name &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Last Name &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Email &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; "
					+ "Father's Name &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ "Class &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Age");
			
			while(rs.next())
			{
				String firstName = rs.getString("First_Name");
				String lastName = rs.getString("Last_Name");
				String email = rs.getString("EMail");
				String fatherName = rs.getString("Fathers_Name");
				int classNumber = Integer.parseInt(rs.getString("Class"));
				int age = Integer.parseInt(rs.getString("Age"));  
				out.println("<html><head><title>Update Student</title><body><form action=UpdateTable method=post><input type=hidden name=id value='"+id+"'/>"
						+ "<input type=text name=firstname value="+ firstName+"> "
						+ "<input type=text name=lastname value=" + lastName+"> <input type=text name=email value=" + email +"><input type=text name=fathername value= "+ fatherName+">"
						+"<input type=text name=class value=" + classNumber+"><input type=text name=age value=" + age+">"
						+ "<input type=submit value=update></form>");	
			}
			out.println("</body></html>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}