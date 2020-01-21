
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArrOperation
{
	/**
	 * 
	 * @param array 
	 * @param size
	 * @return size of maximum mirror section
	 */
	public int mirror(int []arr,int size) throws AssertionError
	{
		
		int max=0;
		
		if(arr.length==0)
		{
			
				throw new AssertionError("Assertion Error occured"); 
			
		}
		int [][]matrix=new int[size+1][size+1];
		
		for(int i=0; i<=size; i++)
		{
			for(int j=0; j<=size; j++)
			{
				if(i==0 || j==0)
				{
					matrix[i][j] = 0;
				}
				else if(arr[i-1] == arr[size-j])
				{
					matrix[i][j] = matrix[i-1][j-1]+1;
				}
				else
				{
					matrix[i][j] = 0;
				}
				if(max< matrix[i][j])
				{
					max= matrix[i][j];
				}
				
			}
			
		}
		
		
		
		return max;
		}
		
		
	
	/**
	 * 
	 * @param arr
	 * @param size
	 * @return
	 */
	public int splitArray(int []arr,int size) throws AssertionError
	{
		
		int index=-1;
		
		if(arr.length == 0)
		{
			throw new AssertionError();
		}
		
		int leftarr = arr[0], rightarr=0;
		
		
		for(int i=0; i<size-1; i++)
		{
			rightarr =0;
			for(int j=i+1; j<size; j++)
			{
				rightarr= rightarr + arr[j];
			}
			if(leftarr == rightarr)
			{
				index= i+1;
				return index;
			}
			else
			{
				leftarr= leftarr + arr[i+1];
			}
		}
		
		return index;
		}
		
		
	
	/**
	 * 
	 * @param arr
	 * @param size
	 * @return number of clumps in the array
	 */
	public int numberOfClumps(int []arr,int size) throws AssertionError
	{
		if(size == 0)
			throw new AssertionError("Assertion Error occured");
		
		int count=0;
		int element =-1;
		
		for(int i=0; i<size-1; i++)
		{
			if(arr[i] == arr[i+1] && element != arr[i])
			{
				count++;
				element = arr[i];
			}
			else
			{
				if(arr[i]!= element)
				{
					element = -1;
				}
			}
			
		}
		
		return count;
		}
		
	
	/**
	 * 
	 * @param array
	 * @param x
	 * @param y
	 * @param size
	 * @return arranged array
	 */
	
	public int[] fixXY(int []arr,int x,int y,int size) throws AssertionError
	{
		try
		{
		
		int []newarr= arr;
		
		int countx=0,county=0;
		
		List <Integer>posx=new ArrayList<Integer>();
		List <Integer>posy=new ArrayList<Integer>();
		
		for(int i=0; i<size; i++)
		{
				if(newarr[i] == x) 
				{
					posx.add(i);
					countx++;
				}
				if(newarr[i] == y)
				{
					posy.add(i);
					county++;
				}
				if(i< size-1)
				{
				if(newarr[i] == newarr[i+1] && newarr[i]== x)
				{
					throw new AssertionError();
				}
				}
				
		}
		if(newarr[size-1] == x)
		{
			throw new AssertionError();
		}
		if(countx!=county)
		{
			throw new AssertionError();
		}
		if(newarr.length==0)
		{
			throw new AssertionError();
		}
		
		
		for(int i=0;i<countx;i++)
		{
			int temp= newarr[posx.get(i)+1];
			newarr[posx.get(i)+1] = newarr[posy.get(i)];
			newarr[posy.get(i)] = temp;
		}
		
		return newarr;
		}
		catch(AssertionError e)
		{
			System.out.println("Assertion Error occured");
			return new int[]{-1};
		}
	}
	
	public static void main(String[] args)
	{

		int[] arr= new int[10];
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int size=sc.nextInt();
		System.out.println("Enter the elements");
		
		for(int i=0; i<size; i++)
		{
			arr[i]=sc.nextInt();
		}
		ArrOperation arroperation=new ArrOperation();
		
		int max=arroperation.mirror(arr, size);
		System.out.println("Size of max mirror section= "+max);
		
		int clumps=arroperation.numberOfClumps(arr,size);
		System.out.println("Number of clumps= "+clumps);
		
		System.out.println("Enter X and Y");
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		int newarr[];
		newarr=arroperation.fixXY(arr, x, y,size);
		for(int i=0; i<size; i++)
		{
			System.out.println(newarr[i]);
		}
		
		int splitindex=arroperation.splitArray(arr, size);
		System.out.println(splitindex);
		
	}
	
	
}
