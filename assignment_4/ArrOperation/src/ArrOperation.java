
import java.util.ArrayList;
import java.util.List;


public class ArrOperation
{
	/**
	 * 
	 * @param array 
	 * @param size
	 * @return size of maximum mirror section
	 */
	public int Mirror(int []arr,int size) throws AssertionError
	{
		try
		{
		int max=0;
		
		if(arr.length==0)
		{
			
				throw new AssertionError(); 
			
		}
		int [][]matrix=new int[size+1][size+1];
		for(int i=0;i<=size;i++)
		{
			for(int j=0;j<=size;j++)
			{
				if(i==0||j==0)
				{
					matrix[i][j]=0;
				}
				else if(arr[i-1]==arr[size-j])
				{
					matrix[i][j]=matrix[i-1][j-1]+1;
				}
				else
				{
					matrix[i][j]=0;
				}
				if(max<matrix[i][j])
				{
					max=matrix[i][j];
				}
				
			}
			
		}
		
		
		
		return max;
		}
		
		catch(AssertionError e)
		{
			return -1;
		}
	}
	
	/**
	 * 
	 * @param arr
	 * @param size
	 * @return
	 */
	public int SplitArray(int []arr,int size) throws AssertionError
	{
		try
		{
		int index=-1;
		if(arr.length==0)
		{
			throw new AssertionError();
		}
		
		int leftarr=arr[0],rightarr=0;
		
		
		for(int i=0;i<size-1;i++)
		{
			rightarr=0;
			for(int j=i+1;j<size;j++)
			{
				rightarr=rightarr+arr[j];
			}
			if(leftarr==rightarr)
			{
				index=i+1;
				return index;
			}
			else
			{
				leftarr=leftarr+arr[i+1];
			}
		}
		
		return index;
		}
		
		catch(AssertionError e)
		{
			return -2;
		}
	}
	
	/**
	 * 
	 * @param arr
	 * @param size
	 * @return number of clumps in the array
	 */
	public int NumberofClumps(int []arr,int size) throws AssertionError
	{
		try
		{
		if(arr.length==0)
		{
			throw new AssertionError();
		}
		int count=0;
		int element=-1;
		for(int i=0;i<size-1;i++)
		{
			if(arr[i]==arr[i+1] && element!=arr[i])
			{
				count++;
				element=arr[i];
			}
			else
			{
				if(arr[i]!=element)
				{
					element=-1;
				}
			}
			
		}
		
		return count;
		}
		catch(AssertionError e)
		{
			return -1;
		}
		
	}
	/**
	 * 
	 * @param array
	 * @param x
	 * @param y
	 * @param size
	 * @return arranged array
	 */
	
	public int[] FixXY(int []arr,int x,int y,int size) throws AssertionError
	{
		try
		{
		
		int []new_arr=arr;
		int countx=0,county=0;
		List <Integer>posx=new ArrayList<Integer>();
		List <Integer>posy=new ArrayList<Integer>();
		for(int i=0;i<size;i++)
		{
				if(new_arr[i]==x) 
				{
					posx.add(i);
					countx++;
				}
				if(new_arr[i]==y)
				{
					posy.add(i);
					county++;
				}
				if(i<size-1)
				{
				if(new_arr[i]==new_arr[i+1] && new_arr[i]==x)
				{
					throw new AssertionError();
				}
				}
				
		}
		if(new_arr[size-1]==x)
		{
			throw new AssertionError();
		}
		if(countx!=county)
		{
			throw new AssertionError();
		}
		if(new_arr.length==0)
		{
			throw new AssertionError();
		}
		
		
		for(int i=0;i<countx;i++)
		{
			int temp=new_arr[posx.get(i)+1];
			new_arr[posx.get(i)+1]=new_arr[posy.get(i)];
			new_arr[posy.get(i)]=temp;
		}
		
		return new_arr;
		}
		catch(AssertionError e)
		{
			return new int[]{-1};
		}
	}
	
	

}
