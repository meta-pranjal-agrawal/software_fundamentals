package q1;

public class LinkedList 
{
	Node head=null;
	
	/**
	 * used to add a node in a linked list
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
				node=node.next;
			}
			node.next=newNode;
		}
	}
	
	/**
	 * prints all the nodes in the linked list
	 */
	public void showNodes()
	{
		System.out.println("Linked List is:");
		Node node= head;
		if(node==null)
		{
			System.out.println("empty list");
		}
		while(node!=null)
		{
			System.out.println(node.data);
			node=node.next;
		}
	}
	
	/**
	 * detects the loop in the linked list
	 * @returns true when finds the loop false otherwise
	 */
	public boolean detectLoop()
	{
		Node slow=head,fast=head;
		
		while(slow!=null && fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * used to create a loop in the linked list
	 */
	public void createLoop()
	{
		Node n = head;
		if(n==null)
		{
			return;
		}
		while(n.next!=null)
		{
			n=n.next;
		}
		n.next=head;
	}
	
	
	public static void main(String arg[])
	{
		LinkedList linkedList= new LinkedList();
		linkedList.addNode(4);
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(7);

		linkedList.showNodes();
		linkedList.createLoop();
		System.out.println(linkedList.detectLoop());
	}

}
