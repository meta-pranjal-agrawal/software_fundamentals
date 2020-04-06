package q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCollection 
{
	private List<Employee> employeeList;
	
	public EmployeeCollection()
	{
		employeeList= new ArrayList<Employee>();
		
	}
	
	/**
	 * method to add employee in employee list
	 * @param employee
	 * @throws Exception
	 */
	public void addEmployee(Employee employee) throws Exception
	{
		if(employee==null)
		{
			throw new Exception("null employee cannot be added");
		}
		if(isUnique(employee.getId()))
		{
			employeeList.add(employee);
		}
		else
		{
			throw new Exception (employee.getId()+" ID exists");
		}
		
	}
	
	/**
	 * method to check if the id entered is unique
	 * @param id
	 * @return
	 */
	public boolean isUnique(int id)
	{
		for(Employee iterator: employeeList)
		{
			if(iterator.getId()==id)
			{
				return false;
			}
		}

		return true;
	}
	
	/**
	 * method used to sort the employees on the basis of their id
	 * @return sorted list by id
	 */
	public List<Employee> sortById()
	{
		List<Employee> sortedList= employeeList;
		Collections.sort(sortedList);
		return sortedList;
	}
	
	/**
	 * 
	 * @return sorted list by names
	 */
	public List<Employee> sortByName() {
		List<Employee> sortedList1 = this.employeeList;
		Collections.sort(sortedList1, new SortByName());
		return sortedList1;
	}
	
	
}
