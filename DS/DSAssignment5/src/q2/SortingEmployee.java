package q2;

public class SortingEmployee {
	EmployeeNode head;
	EmployeeNode sorted;

	public void addEmployee(Employee employee) throws Exception {
		if (employee == null) {
			throw new Exception("Invalid employee");
		}

		EmployeeNode node = new EmployeeNode(employee);
		if (head == null) {
			head = node;
		} else {
			EmployeeNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	public void showEmployees() throws Exception {
		if (head == null) {
			throw new Exception("empty list");
		}

		EmployeeNode current = head;

		while (current != null) {
			System.out.println(current.employee.getName());
			current = current.next;
		}

	}

	public void sortEmployees() throws Exception {
		EmployeeNode current = head;
		if (current == null) {
			throw new Exception("list is empty");
		}

		while (current != null) {
			EmployeeNode next = current.next;
			sortedInsert(current);
			current = next;
		}
		head = sorted;

	}

	public void sortedInsert(EmployeeNode newNode) {
		if (sorted == null || sorted.employee.salary <= newNode.employee.salary) {
			newNode.next = sorted;
			sorted = newNode;
		} else {
			EmployeeNode current = sorted;
			while(current.next != null && current.next.employee.salary > newNode.employee.salary) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

}
