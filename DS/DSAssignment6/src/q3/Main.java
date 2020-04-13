package q3;

public class Main 
{
	public static void main(String arg[])
	{
	Main obj = new Main();
	try
	{
	obj.userInput();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	}
	
	public void userInput() throws Exception
	{
		LinkedList linkedList= new LinkedList();
		linkedList.addEmployee(new Employee(1, "Pranjal", 1000,10));
		linkedList.addEmployee(new Employee(2, "Shashank", 3000,12));
		linkedList.addEmployee(new Employee(3, "ABC", 2000,13));
		linkedList.addEmployee(new Employee(3, "PQR", 2000,14));
		linkedList.addEmployee(new Employee(3, "XYZ", 2000,14));
		linkedList.addEmployee(new Employee(3, "ASDASD", 2000,14));
		
		System.out.println("before sorting");
		linkedList.showEmployees();
		Node n = linkedList.head;
		while(n.next!=null)
			n= n.next;
		linkedList.sort(linkedList.head,n);
		System.out.println("after sorting");
		linkedList.showEmployees();
	}
}
