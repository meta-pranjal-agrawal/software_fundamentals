package q3;

import q3.Employee;
import q3.Node;

public class LinkedList {
	Node head;
	Node sorted;

	/**
	 * method to add employees 
	 * @param employee
	 * @throws Exception
	 */
	public void addEmployee(Employee employee) throws Exception {
		if (employee == null) {
			throw new Exception("Invalid employee");
		}

		Node node = new Node(employee);
		if (head == null) {
			head = node;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}
	
	/**
	 * method to print all employees
	 * @throws Exception
	 */
	public void showEmployees() throws Exception {
		if (head == null) {
			throw new Exception("empty list");
		}

		Node current = head;

		while (current != null) {
			System.out.println(current.employee);
			current = current.next;
		}

	}
	
	/**
	 * returns the pivot element
	 * @param start
	 * @param end
	 * @return
	 */
	public Node partitionLast(Node start, Node end) {
		if (start == end || start == null || end == null) {
			return start;
		}

		Node pivot_prev = start;
		Node curr = start;
		Employee pivot = end.employee;

		while (start != end) {
			if ((start.employee.salary > pivot.salary) || ((start.employee.salary == pivot.salary) && (start.employee.age<pivot.age))) {
				pivot_prev = curr;
				Employee temp = curr.employee;
				curr.employee = start.employee;
				start.employee= temp;
				curr = curr.next;
			}
			start = start.next;
		}
		Employee temp = curr.employee;
		curr.employee = pivot;
		end.employee = temp;

		return pivot_prev;

	}
	
	/**
	 * method to sort the list
	 * @param start
	 * @param end
	 */
	public void sort(Node start, Node end) {
		if (start == end)
			return;
		Node pivot_prev = partitionLast(start, end);
		sort(start, pivot_prev);
		if (pivot_prev != null && pivot_prev == start) {
			sort(pivot_prev.next, end);
		} else if (pivot_prev != null && pivot_prev.next != null) {
			sort(pivot_prev.next.next, end);
		}
	}

}
