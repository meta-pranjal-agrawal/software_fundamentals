import java.util.Scanner;


public class Arithmatic 
{
	/**
	 * 
	 * @param n1
	 * @param n2
	 * @return Lcm of two numbers
	 */
	
	 int lcm=1;
	public int getLcm(int n1,int n2) 
	{
		try
		{
		if(lcm%n1 ==0 && lcm%n2 ==0)
		{
			return lcm;
		}		
		}
		catch(ArithmeticException e)
		{
			System.out.print("divide by 0 error");
			return -1;
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
			return -1;
		}
		
		lcm++;
		return getLcm(n1,n2);
		
	}
	 
	/**
	 * 
	 * @param n1
	 * @param n2
	 * @return Hcf of two numbers
	 */
	
	public int getHcf(int n1,int n2)
	{
		if(n1 == 0)
			return n2;
		return getHcf(n2%n1 , n1);
	}

	public static void main(String[] args) 
	{
		Arithmatic arithmatic = new Arithmatic();
		System.out.println("Enter 2 numbers to calculate lcm and hcf");
		Scanner scanner= new Scanner(System.in);
		int n1,n2;
		try
		{
			 n1=scanner.nextInt();
			 n2=scanner.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Enter correct input");
			scanner.nextLine();
			n1=scanner.nextInt();
			n2=scanner.nextInt();
		}
		if(n1>0 && n2>0)
		{
			int lcm = arithmatic.getLcm(n1, n2);
			System.out.println("LCM= "+lcm);
			int hcf = arithmatic.getHcf(n1, n2);
			System.out.println("HCF= "+hcf);
		}
		else
		{
			System.out.println("Enter number greater than 0");
		}

	}

}
