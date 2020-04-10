package q3;

public class Employee 
{
	 String name;
	 int id;
	 float salary;
	 int age;
	
	public Employee(int id,String name,float salary,int age) 
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.age=age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary
				+ ", age=" + age + "]";
	}

	

	
	
	

}
