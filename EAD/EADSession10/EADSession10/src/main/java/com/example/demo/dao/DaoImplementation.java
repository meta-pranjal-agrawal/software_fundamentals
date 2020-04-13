package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

@Repository
public class DaoImplementation implements DaoInterface {
	Connection connection = ConnectionUtility.getConnection();
	
	/**
	 * show details
	 */
	@Override
	public HashMap<Employee, Vehicle> showDetails(Login login) throws SQLException {
		String query = "select * from employeedetails, vehicledetails where Mail='" + login.getMail()
				+ "' and employeedetails.EmployeeId=vehicledetails.EmployeeId";

		
		Statement statement = (Statement) connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		HashMap<Employee, Vehicle> details = new HashMap<>();

		while (result.next()) {
			Employee key = new Employee(result.getInt("EmployeeId"), result.getString("EmployeeName"),
					result.getString("Gender"), result.getString("Mail"), result.getString("Organisation"),
					result.getString("Contact"));
			Vehicle value = new Vehicle(result.getString("VehicleName"), result.getString("VehicleType"),
					result.getString("VehicleNumber"), result.getString("Plan"), result.getInt("Price"),
					result.getString("Description"));

			
			details.put(key, value);
		}
		return details;
	}
	
	/**
	 * check if user exists
	 */
	@Override
	public Boolean checkUserExists(Employee employee) throws Exception {
		Statement statement = (Statement) connection.createStatement();
		 String query="select count(*) as count from employeedetails where Mail='" + employee.getMail() + "'";
		ResultSet resultTable = statement.executeQuery(query);
		resultTable.next();
		if (resultTable.getInt("count") == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * adds user details
	 */
	@Override
	public Boolean addUserDetails(Employee employee) throws SQLException {
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(
				"insert into employeedetails (EmployeeName, Gender,Mail,Password,Organisation,Contact) values (?,?,?,?,?,?)");
		statement.setString(1, employee.getFullName());
		statement.setString(2, employee.getGender());
		statement.setString(3, employee.getMail());
		statement.setString(4, employee.getPassword());
		statement.setString(5, employee.getOrganisation());
		statement.setString(6, employee.getContactDetails());
		statement.executeUpdate();
		return true;
	}
	
	/**
	 * add vehicle details
	 */
	@Override
	public List<Integer> addVehicleDetails(Vehicle vehicle, Employee employee, HttpSession session)
			throws SQLException {
		Employee employeeDetails = (Employee) session.getAttribute("employeeDetails");
		Statement statement = (Statement) connection.createStatement();
		String query = "select EmployeeId from employeedetails where Mail= '" + employeeDetails.getMail() + "'";
		
		ResultSet resultTable = statement.executeQuery(query);
		resultTable.next();
		session.setAttribute("id", resultTable.getInt(1));
		PreparedStatement prepareStatement = (PreparedStatement) connection.prepareStatement(
				"insert into vehicledetails (EmployeeId, VehicleName, VehicleType, VehicleNumber, Description) values(?,?,?,?,?)");

		prepareStatement.setInt(1, resultTable.getInt(1));
		prepareStatement.setString(2, vehicle.getVehicleName());
		prepareStatement.setString(3, vehicle.getVehicleType());
		prepareStatement.setString(4, vehicle.getVehicleNumber());
		prepareStatement.setString(5, vehicle.getDescription());
		prepareStatement.executeUpdate();
		query = "select * from passdetails where VehicleType = '" + vehicle.getVehicleType() + "'";
		resultTable = statement.executeQuery(query);
		resultTable.next();
		List<Integer> listOfPrices = new ArrayList<>();
		listOfPrices.add(resultTable.getInt(2));
		listOfPrices.add(resultTable.getInt(3));
		listOfPrices.add(resultTable.getInt(4));
		return listOfPrices;
	}
	
	/**
	 * gets pass
	 */
	@Override
	public Boolean getPass(Pass pass, HttpSession session) throws SQLException {
		String query;
		int passValue = 0;
		
		if (pass.getPassChoice().equals("Daily")) {
			passValue = pass.getDailypassValue();
		} else if (pass.getPassChoice().equals("Monthly")) {
			passValue = pass.getMonthlypassValue();
		} else if (pass.getPassChoice().equals("Yearly")) {
			passValue = pass.getYearlypassValue();
		}

		query = "update vehicledetails set Plan='" + pass.getPassChoice() + "' ,Price = " + passValue
				+ " where EmployeeId = " + session.getAttribute("id");
		Statement statement = (Statement) connection.createStatement();
		statement.executeUpdate(query);

		return true;
	}

	/**
	 * show friends
	 */
	@Override
	public ArrayList<Employee> showFriends(HttpSession session) throws SQLException {
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(
				"SELECT * from employeedetails WHERE Mail != ? and Organisation = (select Organisation from employeedetails where Mail = ?)");
		Login login = (Login) session.getAttribute("employee");
		statement.setString(1, login.getMail());
		statement.setString(2, login.getMail());
		ResultSet result = statement.executeQuery();

		ArrayList<Employee> list = new ArrayList<>();
		while (result.next()) {
			list.add(new Employee(result.getInt("EmployeeId"), result.getString("EmployeeName"),
					result.getString("Gender"), result.getString("Mail"), result.getString("Organisation"),
					result.getString("Contact")));
		}
		return list;
	}
	
	/**
	 * validate user
	 */
	@Override
	public Boolean validateUser(Login login) throws Exception {
		int count = selectQuery(connection, login.getMail(), login.getPassword());

		if (count == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * add image
	 */
	@Override
	public Boolean addImageName(HttpSession session, String name) throws SQLException {
		Login login = (Login) session.getAttribute("employee");
		Statement statement = connection.createStatement();
		String query = "select EmployeeId from employeedetails where Mail= '" + login.getMail() + "'";

		ResultSet result = statement.executeQuery(query);
		result.next();
		query = "update employeedetails set imageName='" + name + "' where EmployeeId='" + result.getInt(1) + "'";
		statement.executeUpdate(query);
		return true;
	}
	
	/**
	 * check if image exists
	 */
	@Override
	public String checkImageExists(HttpSession session) throws SQLException {
		String name;
		Statement statement = connection.createStatement();
		Login login = (Login) session.getAttribute("employee");
		String query = "select imageName from employeedetails where Mail = '" + login.getMail() + "'";
		ResultSet result = statement.executeQuery(query);
		result.next();
		name = result.getString("imageName");
		
		return name;
	}
	
	/**
	 * 
	 * @param connection
	 * @param login
	 * @param password
	 * @return number of employee corressponding email
	 * @throws SQLException
	 */
	private int selectQuery(Connection connection, String login, String password) throws SQLException {
		int count = 0;
		String query = "select count(*) from employeedetails where Mail='" + login + "' and Password='" + password
				+ "'";
		Statement statement = (Statement) connection.createStatement();
		ResultSet outputTable = statement.executeQuery(query);
		outputTable.next();
		count = outputTable.getInt("count(*)");
		return count;
	}

}
