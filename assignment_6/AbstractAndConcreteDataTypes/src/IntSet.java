import java.util.Arrays;

public final class IntSet 
{
	
	final int[] set;

	public IntSet(int[] set)
	{
		this.set = set;
	}
	
	/**
	 * 
	 * @param x
	 * @return true when x exists in the set false otherwise
	 */
	public boolean isMember(int x) 
	{	
		if(set.length<=0)
			return false;
		
		for (int i = 0; i < set.length; i++) 
		{
			if (x == set[i]) 
			{
				return true;
			}

		}

		return false;
	}
	
	/**
	 * 
	 * @return size of set
	 */
	public int size()  
	{
		return set.length;
	}
	
	
	/**
	 * 
	 * @param subSet
	 * @return true if if parameter is a subset of the set
	 */
	 
	public boolean isSubSet(IntSet subSet)
	{
		if(subSet.set.length<=0)
			return true; 
		if (subSet.set.length <= set.length)
		{
			for (int i = 0; i < subSet.set.length; i++) 
			{
				if (isMember(subSet.set[i]) == false) 
				{
					return false;
				}
			}
			return true;

		}

		return false;
	}
	
	/**
	 * 
	 * @return the complement of the set with respect to universal set  
	 */
	public IntSet getComplement() 
	{
		if(set.length<=0)
		{
			int []universalSet= new int[1000];
			for(int i=0; i<1000; i++)
			{
				universalSet[i] = i+1;
			}
			IntSet intSetUniversal= new IntSet(universalSet);
			return intSetUniversal;
		}
			
		int[] complement = new int[1000 - set.length];
		int j = 0;
		for (int i = 1; i <= 1000; i++) 
		{
			if (!isMember(i)) 
			{
				complement[j] = i;
				j++;
			}
		}
		
		IntSet intSet1 = new IntSet(complement);
		return intSet1;
	}
	
	/**
	 * 
	 * @param set1
	 * @param set2
	 * @return union of 2 sets
	 */

	public IntSet union(IntSet set1, IntSet set2)
	{
		Arrays.sort(set1.set);
		Arrays.sort(set2.set);
		if(set1.set.length<=0 && set2.set.length<=0)
		{
			IntSet intset2= new IntSet(new int[]{});
			return intset2;
		}
		
		if(set1.set.length<= 0)
		{
			return set2;
		}
		
		if(set2.set.length<= 0)
		{
			return set1;
		}
		
		
		int count = 0;
		for (int i = 0; i < set1.set.length; i++) 
		{
			for (int j = 0; j < set2.set.length; j++) 
			{
				if (set1.set[i] == set2.set[j])
					count++;
			}
		}
		
		int unionsize = set1.set.length + set2.set.length - count;
		int union[] = new int[unionsize];
		int k = 0;
		for(int i=0; i<set1.set.length; i++)
		{
			union[k]=set1.set[i];
			k++;
		}
		
		for(int j=0; j<set2.set.length; j++)
		{
			if(!(set1.isMember(set2.set[j])))
			{
				union[k] = set2.set[j];
				k++;
			}
		}
		
		IntSet intSet2= new IntSet(union);
		return intSet2;
	}

	/*public static void main(String[] args) 
	{
		
		IntSet intSet = new IntSet(new int[] { 1, 2, 3, 4 });
		IntSet subSet= new IntSet(new int[]{3,4});
		System.out.println(intSet.isMember(6));
		System.out.println(intSet.isSubSet(subSet));
		IntSet intSet1=intSet.getComplement();
		IntSet intSet2=intSet.union(new IntSet(new int[] { 2, 3, 4 }),new IntSet(new int[] { 3, 4, 5, 6 }));
		
		
		System.out.println("complement:");
		for(int i=0;i<intSet1.set.length;i++)
		{
			System.out.println(intSet1.set[i]);
		}
		
		
		System.out.println("union:");
		for(int i=0;i<intSet2.set.length;i++)
		{
			System.out.println(intSet2.set[i]);
		}
 
	}*/

}
