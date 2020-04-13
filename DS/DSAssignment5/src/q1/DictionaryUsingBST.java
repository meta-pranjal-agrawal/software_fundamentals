package q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONObject;

public class DictionaryUsingBST implements DictionaryInterface
{
	Node root;
	
	public DictionaryUsingBST(JSONObject object) throws Exception 
	{
		if(object==null)
		{
			throw new Exception("Null data found");
		}
		
		for(Object entry: object.entrySet())
		{
			String key=(String)((Entry<?,?>)entry).getKey();
			String value = (String)((Entry<?,?>)entry).getValue();
			addElementToDictionary(new Element(key,value));
		}
	}
	
	/**
	 * method called by user to add an element
	 */
	@Override
	public void addElementToDictionary(Element element) throws Exception {
		if(element==null)
		{
			throw new Exception("Null object passed");
		}
		
		Node newNode= new Node(element);
		
		this.root=addElement(root,newNode);
		
	}
	
	/**
	 * method called by a program to add an element  
	 * @param currentRoot
	 * @param newNode
	 * @return
	 */
	public Node addElement(Node currentRoot,Node newNode)
	{
		if(currentRoot==null)
		{
			return newNode;
		}
		if(currentRoot.getElement().getKey().compareTo(newNode.getElement().getKey())<0)
		{
			currentRoot.setRightNode(addElement(currentRoot.getRightNode(), newNode));
		}
		else if(currentRoot.getElement().getKey().compareTo(newNode.getElement().getKey())>0)
		{
			currentRoot.setLeftNode(addElement(currentRoot.getLeftNode(), newNode));
		}
		
		return currentRoot;
				
	}
	
	/**
	 * method to get the value of a key
	 */
	@Override
	public String getValueOfKey(String key) throws Exception {
		if(key.trim().length()==0)
		{
			throw new Exception("Enter valid key");
		}
		String value=searchKey(root,key);
		return value;
	}
	
	/**
	 * method to search a key in the tree by the program
	 * @param root
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private String searchKey(Node root,String key) throws Exception
	{
		if(root==null)
		{
			throw new Exception("key not found");
		}
		if(root.getElement().getKey().equals(key))
		{
			return root.getElement().getValue();
		}
		if(root.getElement().getKey().compareTo(key)<0)
		{
			root=root.getRightNode();
			return searchKey(root, key);
		}
		return searchKey(root.getLeftNode(), key);
		
	}

	/** method to sort the list called by user
	 *
	 */
	@Override
	public List<Element> sortKeyValuePairs() 
	{
		List<Element> sortedList=new ArrayList<Element>();
		sortedList=sort(root,sortedList);
		return sortedList;
	}
	
	/**
	 * method to sort the list
	 * @param root
	 * @param sortedList
	 * @return
	 */
	private List<Element> sort(Node root,List<Element> sortedList)
	{
		if(root!=null)
		{
			sort(root.getLeftNode(),sortedList);
			sortedList.add(root.getElement());
			sort(root.getRightNode(),sortedList);
		}
		return sortedList;
	}
	

	/**
	 * method user calls to delete a node
	 */
	@Override
	public void deleteElementFromDictionary(String key) throws Exception 
	{
		if(key.trim().length()==0)
		{
			throw new Exception("Enter valid key");
		}
		
		this.root=deleteElement(this.root,key);
		
	}
	/**
	 * method to delete a node
	 * @param root
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private Node deleteElement(Node root,String key) throws Exception
	{
		if(root==null)
		{
			throw new Exception("Empty Dictionary");
		}
		if(key.compareTo(root.getElement().getKey())<0)
		{
			root.setLeftNode(deleteElement(root.getLeftNode(), key));
		}
		else if(key.compareTo(root.getElement().getKey())>0)
		{
			root.setRightNode(deleteElement(root.getRightNode(), key));
		}
		else
		{
			if((root.getLeftNode()==null)&&(root.getRightNode()==null))
			{
				root=null;
			}
			else if(root.getLeftNode()==null)
			{
				root=root.getRightNode();
			}
			else if(root.getRightNode()==null)
			{
				root= root.getLeftNode();
			}
			else 
			{
				root.setElement(minimumValue(root.getRightNode()));
				root.setRightNode(deleteElement(root.getRightNode(), root.getElement().getKey()));
			}
		}
		return root;
	}
	
	/**
	 * find minimum value on tree
	 * @param root
	 * @return
	 */
	private Element minimumValue(Node root)
	{
		String minimumKey=root.getElement().getKey();
		String minimumValue=root.getElement().getValue();
		while(root.getLeftNode()==null)
		{
			minimumKey=root.getElement().getKey();
			minimumValue=root.getElement().getValue();
			root=root.getLeftNode();
		}
		return new Element(minimumKey,minimumValue);
	}
	
	/**
	 * method to sort key value pairs from one key to another
	 */
	@Override
	public List<Element> sortKeyValuePairsOnCondition(String firstKey,String secondKey) throws Exception 
	{
		if((firstKey.trim().length()==0)||(secondKey.trim().length()==0))
		{
			throw new Exception("Enter valid keys");
		}
		List<Element> sortedList=sortKeyValuePairs();
		if(sortedList.size()==0)
		{
			throw new Exception("Empty Dictionary");
		}
		int iterator =0;
		int firstIndex=-1;
		int secondIndex=-1;
		
		while(iterator<sortedList.size())
		{
			if(sortedList.get(iterator).getKey().equals(firstKey))
			{
				firstIndex=iterator;
			}
			else if(sortedList.get(iterator).getKey().equals(secondKey))
			{
				secondIndex=iterator;
			}
			if((firstIndex!=-1) && (secondIndex!=-1))
			{
				break;
			}
			iterator++;
		}
		if((firstIndex==-1) || (secondIndex==-1))
		{
			throw new Exception("Invalid keys");
		}
		
		return sortedList.subList(firstIndex, secondIndex+1);
	}
	
	/**
	 * show all the nodes
	 */
	@Override
	public void show() throws Exception {
		inorder(this.root);
		
	}
	
	/**
	 * 
	 * @param root
	 * @throws Exception
	 */
	private void inorder(Node root) throws Exception
	{
		if(root!=null)
		{
			inorder(root.getLeftNode());
			System.out.println(root.getElement().getKey());
			inorder(root.getRightNode());
		}
	}
	
	
}
