package q1;

public class Node 
{
	private Element element;
	
	private Node leftNode;
	
	private Node rightNode;
	
	public Node(Element element) {
		this.element=element;
		this.leftNode=null;
		this.rightNode=null;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	

}
