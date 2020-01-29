import java.util.Scanner;


public class StringOperations
{
	/**
	 * 
	 * @param first string s1
	 * @param first string s2
	 * @return 1 if both strings are equals and 0 if unequal
	 */
	
	public int comparision(String s1,String s2)
	{
		char c1[]= new char[s1.length()];
		char c2[]= new char[s2.length()];
		
		c1=s1.toCharArray();
		c2=s2.toCharArray();
		
			if(c1.length==c2.length)
			{
				int flag=0;
				for(int i=0;i<c1.length;i++)
				{
					if(c1[i]!=c2[i])
					{
						flag=1;
						return 0;
					}
				}
				if(flag==0)
				{
					return 1;
				}
			}
			else
			{
				return 0;
			}
			
			return 0;
	}
	
	/**
	 * 
	 * @param String s1 which is to be reversed
	 * @return reversed string
	 */
	
	public String stringReversal(String s1)
	{
		char c1[]= new char[s1.length()];
		char c2[]= new char[s1.length()];
		c1=s1.toCharArray();
		
		int j=0;
		for(int i=s1.length()-1;i>=0;i--)
		{
			c2[j]=c1[i];
			j++;
		}
		
		
		String Srev=new String(c2);
		return Srev;
	}
	
	/**
	 * 
	 * @param string str whose case is to be changed
	 * @return string with uppercase converted to lower and lowercase to upper
	 */
	
	public String changeCase(String str)
	{
		char s[]= new char[str.length()];
		s=str.toCharArray();
		for(int i=0;i<s.length;i++)
		{
			int ascii=(int) s[i];
			if(ascii>='a' && ascii <='z')
			{
				char c= (char) (s[i]-32);
				s[i]=c;
			}
			else if(ascii>='A' && ascii <='Z')
			{
				char c=(char) (s[i]+32);
				s[i]=c;
			}
			else
			{
				char c=(char)(s[i]);
				s[i]=c;
			}
		}
		
		
		String caseconvertedstring=new String(s);
		
		
		return caseconvertedstring;
	}
	
	/**
	 * 
	 * @param sentence
	 * @return largest word in the sentence
	 */
	public String findLongestWord(String sentence)
	{
		String Schar[]= new String[100];
		
		Schar=sentence.split(" ");
		int max=Schar[0].length();
		String longest="";
		for(int i=0;i<Schar.length;i++)
		{
			if(max<=Schar[i].length())
			{
				longest=Schar[i];
				max=Schar[i].length();
			}
		}
		
		return longest;
	}
	

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 2 strings");
		String s1;
		String s2;
		try
		{
			s1= sc.nextLine();
			s2= sc.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input and try again");
			s1="";
			s2="";
			System.exit(0);
		}
		StringOperations stringoperations= new StringOperations();
		
		//calls the comparison method
		int result=stringoperations.comparision(s1, s2);
		if(result==1)
		{
			System.out.println("Strings are equal");
		}
		else
		{
			System.out.println("String are not equal");
		}
		
		//calls the stringReversal method
		String Srev= stringoperations.stringReversal(s1);
		System.out.println("first string when reversed becomes "+Srev);
		
		//calls the changeCase method
		System.out.println("enter the string to change cases");
		String str;
		try
		{
			str= sc.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input");
			str="";
			System.exit(0);
		}
		
		//calls the case conversion method
		String caseconvertedstring=stringoperations.changeCase(str);
		System.out.println(caseconvertedstring);
		
		System.out.println("Enter a sentence");
		String sentence;
		try
		{
			sentence= sc.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("Incorrect input");
			sentence="";
			System.exit(0);
		}
		
		// calls the find longest word method
		String longestword=stringoperations.findLongestWord(sentence);
		System.out.println(longestword);

	}

}
