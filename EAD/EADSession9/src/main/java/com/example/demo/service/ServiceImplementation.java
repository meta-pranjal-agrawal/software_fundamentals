package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DaoImplementation;
import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

@Service
public class ServiceImplementation implements ServiceInterface
{
	/**
	 * validates user
	 */
	@Autowired
	DaoImplementation dao;
	public Boolean validateUser(Login login) throws Exception {
		return dao.validateUser(login);
		
	}
	/**
	 *  returns details
	 */
	@Override
	public HashMap<Employee, Vehicle> showDetails(Login login) throws SQLException {
		return dao.showDetails(login);
	}
	/**
	 * checks if user exists in database
	 */
	@Override
	public Boolean checkUserExists(Employee employee) throws Exception {
	
		return dao.checkUserExists(employee);
	}
	/**
	 * adds user details
	 */
	public Boolean addUserDetails(Employee employee) throws SQLException{
		return dao.addUserDetails(employee);
	}
	/**
	 * adds vehicle details
	 */
	@Override
	public List<Integer> addVehicleDetails(Vehicle vehicle, Employee employee, HttpSession session) throws SQLException {
		
		return dao.addVehicleDetails(vehicle, employee, session);
	}
	/**
	 * gets user pass
	 */
	@Override
	public Boolean getPass(Pass pass, HttpSession session) throws SQLException {
		return dao.getPass(pass,session);
	}
	/**
	 * shows friends
	 */
	public ArrayList<Employee> showFriends(HttpSession session) throws SQLException {
		return dao.showFriends(session);
	}
	/**
	 * adds image
	 */
	@Override
	public Boolean addImageName(HttpSession session, String name) throws SQLException {
		return dao.addImageName(session,name);
		
	}
	/**
	 * checks if image exists
	 */
	@Override
	public String checkImageExists(HttpSession session) throws SQLException {
		 
		return dao.checkImageExists(session);
	}
	
	
}
