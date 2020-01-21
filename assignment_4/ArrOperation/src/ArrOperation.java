
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
	public int getSizeOfMirrorSection(int []arr,int size) throws AssertionError
	{
		
		int maxSizeofMirror=0;
		
		if(arr.length==0)
		{
			
			throw new AssertionError("Array Empty"); 
			
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
				if(maxSizeofMirror< matrix[i][j])
				{
					maxSizeofMirror= matrix[i][j];
				}
				
			}
			
		}
		
		return maxSizeofMirror;
		}
		
		
	
	/**
	 * 
	 * @param arr
	 * @param size
	 * @return
	 */
	public int getSplitArrayIndex(int []arr,int size) throws AssertionError
	{
		
		int index=-1;
		
		if(arr.length == 0)
		{
			throw new AssertionError("Array Empty");
		}
		
		int leftArraySum = arr[0], rightArraySum=0;
		
		
		for(int i=0; i<size-1; i++)
		{
			rightArraySum = 0;
			for(int j=i+1; j<size; j++)
			{
				rightArraySum= rightArraySum + arr[j];
			}
			if(leftArraySum == rightArraySum)
			{
				index= i+1;
				return index;
			}
			else
			{
				leftArraySum= leftArraySum + arr[i+1];
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
	public int getNumberOfClumps(int []arr,int size) throws AssertionError
	{
		if(size == 0)
			throw new AssertionError("Array Empty");
		
		int count=0;
		int element =-1;
		
		for(int i=0; i< size-1; i++)
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
		
		int []newArr= arr;
		
		int countX=0,countY=0;
		
		List <Integer>posX=new ArrayList<Integer>();
		List <Integer>posY=new ArrayList<Integer>();
		
		for(int i=0; i<size; i++)
		{
				if(newArr[i] == x) 
				{
					posX.add(i);
					countX++;
				}
				if(newArr[i] == y)
				{
					posY.add(i);
					countY++;
				}
				if(i< size-1)
				{
				if(newArr[i] == newArr[i+1] && newArr[i]== x)
				{
					throw new AssertionError();
				}
				}
				
		}
		if(newArr[size-1] == x)
		{
			throw new AssertionError();
		}
		if(countX!=countY)
		{
			throw new AssertionError();
		}
		if(newArr.length==0)
		{
			throw new AssertionError();
		}
		
		
		for(int i=0; i<countX; i++)
		{
			int temp= newArr[posX.get(i)+1];
			newArr[posX.get(i)+1] = newArr[posY.get(i)];
			newArr[posY.get(i)] = temp;
		}
		
		return newArr;
		}
		catch(AssertionError e)
		{
			System.out.println("Array Empty");
			return new int[]{-1};
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new int[]{-1};
		}
	}
	
	public static void main(String[] args)
	{

		int[] arr= new int[10];
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int size;
		try
		{
			size=scanner.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Enter correct input");
			size=0;
		}
		
		if(size>0)
		{
			System.out.println("Enter the elements");
			
			
			for(int i=0; i<size; i++)
			{
				try
				{
				arr[i]=scanner.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid input");
					scanner.nextLine();
					arr[i] = scanner.nextInt();
				}
					
			}

			ArrOperation arroperation=new ArrOperation();
	
			int maxSizeofMirror=arroperation.getSizeOfMirrorSection(arr, size);
			System.out.println("Size of max mirror section= "+maxSizeofMirror);
			
			int clumps=arroperation.getNumberOfClumps(arr,size);
			System.out.println("Number of clumps= "+clumps);
			
			System.out.println("Enter X and Y");
		
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			
			int newArr[];
			newArr=arroperation.fixXY(arr, x, y,size);
			for(int i=0; i<size; i++)
			{
				System.out.println(newArr[i]);
			}
			
			
			int splitIndex=arroperation.getSplitArrayIndex(arr, size);
			if(splitIndex>=0)
			{
				System.out.println("Array can be split at= "+splitIndex);
			}
		}
			
		else
		{
			System.out.println("Please enter size greater than 0");
		}
			
	}
	
	
}

