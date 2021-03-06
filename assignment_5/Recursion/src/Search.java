import java.util.Arrays;
import java.util.Scanner;


public class Search 
{
	/**
	 * 
	 * @param arr
	 * @param val
	 * @param size
	 * @param index
	 * @return
	 */
	public int linearSearch(int []arr,int val,int size,int index)
	{
		if(arr.length==0)
		{
			return -1;
		}
		if(index>size-1)
		{
			return -1;
		}
		if(arr[index] == val)
		{
			return index+1;
		}
		
		else
		{
			return linearSearch(arr,val,size,++index);
		}
		
	}
	
	/**
	 * 
	 * @param arr
	 * @param left value
	 * @param right value
	 * @param value to be searched
	 * @return
	 */
	
	public int binarySearch(int []arr,int l,int r,int val)
	{
		if(arr.length==0)
			return -1;
		if(r>= l)
		{
			int mid = (l+r)/2;
			if(arr[mid] == val)
			{
				return mid+1;
			}
			if(arr[mid]> val)
			{
				return binarySearch(arr,l,mid-1,val);
			}
			else
			{
				return binarySearch(arr,mid+1,r,val);
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		Search search= new Search();
		System.out.println("Enter the number of elements");
		Scanner scanner= new Scanner(System.in);
		int size=0;
		try
		{
			size= scanner.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Enter correct input");
			scanner.nextLine();
			size= scanner.nextInt();
		}
		
		if(size>0)
		{
			System.out.println("Enter the elements");
			int []arr = new int[size];
			for(int i=0;i<size;i++)
			{
				try
				{
					arr[i]=scanner.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("Incorrect input");
					arr[i]=scanner.nextInt();
				}
			}
			System.out.println("Enter the value to be searched");
			int value=scanner.nextInt();
			
			int index;
			System.out.println("Enter 1 for linearsearch\nEnter 2 for BinarySearch");
			try
			{
				int ch=scanner.nextInt();
				if(ch==1)
					index=search.linearSearch(arr,value, size, 0);
				else if(ch==2)
				{
					Arrays.sort(arr);
					index= search.binarySearch(arr, 0, size-1, value);
				}
				else
				{	
					System.out.println("Enter correct choice");
					index=-1;
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				index=-1;
			}
			if(index!= -1)
			System.out.println("Element found at index= "+index); 
			else
			{
				System.out.println("Element not found");
			}
			
		}
		else
		{
			System.out.println("Enter size greater than 0");
		}
		
		
	}

}
