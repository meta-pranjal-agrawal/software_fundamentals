package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

public interface ServiceInterface 
{
	public Boolean validateUser(Login login) throws Exception;
	public Boolean checkUserExists(Employee employee) throws Exception;
	public Boolean addUserDetails(Employee employee) throws SQLException;
	public List<Integer> addVehicleDetails(Vehicle vehicle, Employee employee, HttpSession session) throws SQLException;
	public Boolean getPass(Pass pass, HttpSession session) throws SQLException;
	public ArrayList<Employee> showFriends(HttpSession session) throws SQLException;
	public HashMap<Employee, Vehicle> showDetails(Login login) throws SQLException;
	Boolean addImageName(HttpSession session, String name) throws SQLException;
	String checkImageExists(HttpSession session) throws SQLException;

}
