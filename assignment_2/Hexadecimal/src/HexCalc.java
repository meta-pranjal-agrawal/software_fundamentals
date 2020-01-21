import java.util.*;
import java.lang.Math;



public class HexCalc
{
	public String add(String hexa1,String hexa2)
	{
		int number1=Integer.parseInt(hexa1,16);
		int number2=Integer.parseInt(hexa2,16);
		int sum=number1+number2;
		
		String hexsum=Integer.toHexString(sum);
		
	
		return hexsum; 
	}	
	
	public String subtract(String hexa1,String hexa2)
	{
		int number1=Integer.parseInt(hexa1,16);
		int number2=Integer.parseInt(hexa2,16);
		int diff=Math.abs(number1-number2);
		String hexdiff=Integer.toHexString(diff);
		return hexdiff;
	}	
	
	public String multiply(String hexa1,String hexa2)
	{
		int number1=Integer.parseInt(hexa1,16);
		int number2=Integer.parseInt(hexa2,16);
		int product=number1*number2;
		String hexprod=Integer.toHexString(product);
		
		return hexprod;
		
	}
	
	public String divide(String hexa1,String hexa2)
	{
		int number1=Integer.parseInt(hexa1,16);
		int number2=Integer.parseInt(hexa2,16);
		int quotient=number1/number2;
		String hexdiv=Integer.toHexString(quotient);
		
		return hexdiv;
		
	}	
	public boolean isequal(String hexa1,String hexa2)
	{
		if(hexa1.equals(hexa2))
			return true;
		else
			return false;
		
	}
	public boolean isfirstbigger(String hexa1,String hexa2)
	{
		
		if(hexa1.length()==hexa2.length())
		{
			if(hexa1.compareTo(hexa2)>0)
				return true;
			else
				return false;
		}
		
		else
		{
			if(hexa1.length()>hexa2.length())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
	}
	
	public static void main(String arg[])
	{
		HexCalc hex= new HexCalc();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 2 hexadecimal no.s");
		
		String hex1= sc.next();
		String hex2=sc.next();
		
		String sum=hex.add(hex1,hex2);
		String diff=hex.subtract(hex1,hex2);
		String prod=hex.multiply(hex1,hex2);
		String division=hex.divide(hex1,hex2);
		boolean equality=hex.isequal(hex1,hex2);
		boolean compare=hex.isfirstbigger(hex1,hex2);
		
		System.out.println("Sum of 2 hex is: "+sum);
		System.out.println("diffrence of 2 no is: "+diff);
		System.out.println("product of 2 no. is: "+prod);
		System.out.println("division of 2 no. is: "+division);
		if(equality)
		{
			System.out.println("both are equal");
		}
		else
		{
			System.out.println("They are not equal");
			if(compare)
			{
				System.out.println(hex1+" is bigger");
			}
			else
			{
				System.out.println(hex2+" is bigger");
			}
		}
		
		
	
	}
	}