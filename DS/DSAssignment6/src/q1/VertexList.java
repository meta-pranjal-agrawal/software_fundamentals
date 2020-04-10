package q1;

public class VertexList 
{
	private Node head;
	
	public Node getHead()
	{
		return this.head;
	}
	
	/**
	 * function to add vertex
	 * @param vertex to linked list
	 * @param weight
	 */
	public void addVertex(int vertex,int weight)
	{
		Node node = new Node(vertex,weight);
		if(this.head==null)
		{
			this.head=node;
		}
		else
		{
			Node currentNode=this.head;
			while(currentNode.getNext()==null)
			{
				currentNode=currentNode.getNext();
			}
			currentNode.setNext(node);
		}
	}

}
