import static org.junit.Assert.assertEquals;   
import static org.junit.Assert.*;
import org.junit.Test;

public class SearchTest 
{
	@Test
	public void linearSearchTest1()
	{
		Search search = new Search();
		int actualindex= search.linearSearch(new int[]{5,1,3,7,2},7,5,0);
		assertEquals(4,actualindex);
	}
	
	@Test
	public void linearSearchTest2()
	{
		Search search= new Search();
		int actualindex =search.linearSearch(new int[]{0,4,8,2,3,6},0,6,0);
		assertEquals(1,actualindex);
	}
	
	@Test
	public void linearSearchTest3()
	{
		Search search= new Search();
		int actualindex =search.linearSearch(new int[]{10,22,5,2,9,10},3,6,0);
		assertEquals(-1,actualindex);
	}
	
	
	@Test
	public void binarySearchTest1()
	{
		Search search = new Search();
		int actualindex =search.binarySearch(new int[]{2,3,4,5,6},0,5,6);
		assertEquals(5,actualindex);
	}
	
	@Test
	public void binarySearchTest2()
	{
		Search search= new Search();
		int actualindex= search.binarySearch(new int[]{5,8,9,10,23,67},0,6,6);
		assertEquals(-1,actualindex);
	}
	
	@Test
	public void binarySearchTest3()
	{
		Search search= new Search();
		int actualindex= search.binarySearch(new int[]{7,9,12,22,58,66,72},0,7,7);
		assertEquals(1,actualindex);
	}
	


}
