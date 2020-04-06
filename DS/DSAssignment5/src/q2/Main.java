package q2;

public class Main 
{
	public static void main(String arg[])
	{
		Main obj= new Main();
		try {
			obj.userInput();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void userInput() throws Exception
	{
		SortingEmployee employeeList = new SortingEmployee();
		employeeList.addEmployee(new Employee("Pranjal",4000,25));
		employeeList.addEmployee(new Employee("Shashank",2000,27));
		employeeList.addEmployee(new Employee("ABC",3000,29));
		
		employeeList.showEmployees();
		
		employeeList.sortEmployees();
		System.out.println("after sorting");
		employeeList.showEmployees();
		
	}

}
