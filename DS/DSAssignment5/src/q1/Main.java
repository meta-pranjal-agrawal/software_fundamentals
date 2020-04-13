package q1;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main 
{
	public static void main(String arg[])
	{
		Main mainObj= new Main();
		try
		{
			mainObj.userInput();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	private void userInput() throws Exception
	{
		FileReader file = new FileReader("files/data.json");
		JSONParser parser= new JSONParser();
		JSONObject object= (JSONObject) parser.parse(file);
		DictionaryInterface dictionary= new DictionaryUsingBST(object);
		dictionary.addElementToDictionary(new Element("A","1"));
		dictionary.addElementToDictionary(new Element("B","2"));
		dictionary.addElementToDictionary(new Element("C","3"));
		dictionary.addElementToDictionary(new Element("D","4"));
		System.out.println("after insertion");
		dictionary.show();
		System.out.println("after deletion");
		dictionary.deleteElementFromDictionary("C");
		
		dictionary.show();
		
		List<Element> list = dictionary.sortKeyValuePairs();
		System.out.println("size "+list.size());
		for (int i=0;i<list.size();i++){
			System.out.println("List Item "+list.get(i).getKey()+" "+list.get(i).getValue());
		}		
		List<Element> list1 = dictionary.sortKeyValuePairsOnCondition("A","D");
		for (int i=0;i<list1.size();i++){
			System.out.println("List Item "+list1.get(i).getKey()+" "+list1.get(i).getValue());
		}	
	}

}
