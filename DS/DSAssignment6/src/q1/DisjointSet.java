package q1;

public class DisjointSet 
{
	Integer[] parent;
	
	public DisjointSet(int number) throws Exception
	{
		if(number<=0)
		{
			throw new Exception("Invalid size");
		}
		this.parent= new Integer [number];
	}
	
	/**
	 * method to find parent
	 * @param element
	 * @return
	 */
	private int getParent(int element)
	{
		int parentElement= element;
		while(this.parent[parentElement]!=null)
		{
			parentElement=this.parent[parentElement];
		}
		return parentElement;
	}
	
	/**
	 * method to check if elements belong to same set
	 * @param firstElement
	 * @param secondElement
	 * @return
	 */
	public boolean sameSet(int firstElement,int secondElement)
	{
		if(getParent(firstElement)==getParent(secondElement))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * method to find the union
	 * @param firstElement
	 * @param secondElement
	 */
	public void union(int firstElement,int secondElement)
	{
		int firstElementParent= getParent(firstElement);
		int secondElementParent= getParent(secondElement);
		if(firstElementParent != secondElementParent)
		{
			this.parent[secondElementParent]=firstElementParent;
		}
	}

}
