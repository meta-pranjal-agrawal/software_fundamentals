package q2;

public class Main 
{
	public static void main(String arg[]){
		Main obj= new Main();
		try{
			obj.userInput();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void userInput() throws Exception
	{
		UniqueCharacter uniqueCharacter1= new UniqueCharacter("mississippi");
		System.out.println(uniqueCharacter1.countUniqueCharacters());
		UniqueCharacter uniqueCharacter2= new UniqueCharacter("malyalam");
		System.out.println(uniqueCharacter2.countUniqueCharacters());
	}

}
