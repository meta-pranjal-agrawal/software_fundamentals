

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class VehicleRegistration
 */
@WebServlet("/VehicleRegistration")
public class VehicleRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Connection con=ConnectionUtility.getConnection();
			String vehicleName=request.getParameter("vehicleName");
			String vehicleType=request.getParameter("vehicleType");
			String vehicleNumber=request.getParameter("vehicleNumber");
			String identification=request.getParameter("identification");
			String empId=request.getParameter("empId");
			
			PreparedStatement stmt= con.prepareStatement("insert into vehicles values(VehicleID,?,?,?,?,?)");
			
			stmt.setString(1, vehicleName);
			stmt.setString(2, vehicleType);
			stmt.setString(3, vehicleNumber);
			stmt.setString(4, empId);
			stmt.setString(5, identification);
			stmt.executeUpdate();
			
			request.setAttribute("VehicleType", vehicleType);
			RequestDispatcher rd= request.getRequestDispatcher("Pass.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception e)
		{

			System.out.println("inside catch of vehicle reg");
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
	}

}
