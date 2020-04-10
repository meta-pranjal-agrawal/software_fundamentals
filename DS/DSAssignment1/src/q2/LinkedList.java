package q2;

public class LinkedList 
{
	Node head= null;
	
	/**
	 * adds a node in the linked list
	 * @param data
	 */
	public void addNode(int data)
	{
		Node newNode= new Node(data);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			Node node= head;
			while(node.next!=null)
			{
				node = node.next;
			}
			node.next= newNode;
		}
	}
	
	/**
	 * shows all the nodes in the linked list
	 */
	public void showNodes()
	{
		
		System.out.println("Linked List is:");
		Node node = head;
		if(node == null)
		{
			System.out.println("empty list");
		}
		while(node != null)
		{
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	/**
	 * rotates the sublist
	 * @param left
	 * @param right
	 * @param numberOfRotation
	 * @throws Exception
	 */
	public void rotateList(int left, int right, int numberOfRotation) throws Exception 
	{
		Node beforeLeftNode = null;
		Node leftNode = null;
		Node current = head;

		if (head == null) {
			throw new Exception("Empty list");
		}

		int subListSize = right - left + 1;
		if (numberOfRotation >= subListSize) {
			numberOfRotation = numberOfRotation % subListSize;
		}

		if(numberOfRotation>0) {
			for (int i = 1; i < left; i++) {
				beforeLeftNode = current;
				current = current.next;
			}
			leftNode = current;
			for (int i = left; i < right; i++) {
				current = current.next;
			}
			Node rightNode = current;
			Node curr = leftNode;
			for (int i = 0; i < numberOfRotation - 1; i++) 
			{
				curr = curr.next;
			}

			// if first element of sublist is the first element of list
			if (beforeLeftNode == null) 
			{
				head = curr.next;
			}
			else 
			{
				beforeLeftNode.next = curr.next;
			}
			curr.next = rightNode.next;
			rightNode.next = leftNode;

		}
	}

	



	public static void main(String arg[])
	{
		LinkedList linkedList= new LinkedList();
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.showNodes();
		try
		{
			linkedList.rotateList(2, 5, 2);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		linkedList.showNodes();

	}

}
