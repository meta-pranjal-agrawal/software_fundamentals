package q1;

import java.util.List;

public class Main 
{
	public static void main(String arg[])
	{
		Main obj = new Main();
		try{
			obj.userInput();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	/**
	 * method to take user input and perform sorting
	 * @throws Exception
	 */
	public void userInput() throws Exception
	{
		EmployeeCollection employeeCollection= new EmployeeCollection();
		employeeCollection.addEmployee(new Employee(3, "Pranjal", "abc xyz"));
		employeeCollection.addEmployee(new Employee(1, "Shashank", "pqr xyz"));
		employeeCollection.addEmployee(new Employee(2, "ASDS", "abc xyz"));
		
		List<Employee> sortedListOnId= employeeCollection.sortById();
		for (Employee employee : sortedListOnId) {
			System.out.println(employee.getEmployeeName());
		}
		
		List<Employee> sortedListbyName=employeeCollection.sortByName();
		for (Employee employee : sortedListbyName	) {
			System.out.println(employee.getEmployeeName());
		}
		
	}
}
