package q2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacter 
{
	private HashMap<String,Integer> enteredStrings=new HashMap<String, Integer>();
	private String inputString;
	
	/**
	 * method to store the input string without spaces 
	 * @param inputString
	 * @throws Exception
	 */
	public UniqueCharacter(String inputString) throws Exception
	{
		if(inputString.trim().length()==0)
		{
			throw new Exception("invalid string");
		}
		this.inputString=inputString;
	}
	
	/**
	 * method to count number of unique characters
	 * @return the number of unique characters
	 */
	public int countUniqueCharacters()
	{
		if(enteredStrings.containsKey(inputString))
		{
			return enteredStrings.get(inputString);
		}
		
		int numberOfUniqueCharacters=0;
		Set<Character> uniqueCharacters=new HashSet<Character>();
		for(int i=0;i<inputString.length();i++)
		{
			uniqueCharacters.add(inputString.charAt(i));
		}
		numberOfUniqueCharacters=uniqueCharacters.size();
		enteredStrings.put(inputString, numberOfUniqueCharacters);
		return numberOfUniqueCharacters;
		
	}

}
