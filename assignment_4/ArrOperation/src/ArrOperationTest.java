import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrOperationTest 
{
	@Test
	public void getSizeOfMirrorSectionTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.getSizeOfMirrorSection(new int[]{1,2,3,8,9,3,2,1}, 8);
		assertEquals(3,size);
		
	}
	
	@Test
	public void getSizeOfMirrorSectionTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.getSizeOfMirrorSection(new int[]{7,1,4,9,7,4,1}, 7);
		assertEquals(2,size);
		
	}
	
	@Test
	public void getSizeOfMirrorSectionTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.getSizeOfMirrorSection(new int[]{1,2,1,4},4);
		assertEquals(3,size);
	}

	@Test(expected=AssertionError.class)
	public void getSizeOfMirrorSectionTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.getSizeOfMirrorSection(new int[]{},0);
		assertEquals(-1,size);
	}
	
	
	@Test
	public void getNumberOfClumpsTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.getNumberOfClumps(new int[]{1,2,2,3,4,4},6);
		assertEquals(2,clumps);			
	}
	
	@Test
	public void getNumberOfClumpsTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.getNumberOfClumps(new int[]{1,1,2,1,1},5);
		assertEquals(2,clumps);
		
	}
	
	@Test
	public void getNumberOfClumpsTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.getNumberOfClumps(new int[]{1,1,1,1,1},5);
		assertEquals(1,clumps);
		
	} 
	
	@Test(expected=AssertionError.class)
	public void getNumberOfClumpsTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.getNumberOfClumps(new int[]{},0);
		//assertEquals(-1,clumps);			
	}
	
	
	@Test
	public void fixXYTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.fixXY(new int[]{5,4,9,4,9,5}, 4, 5, 6);
		int []expectedresult=new int[]{9,4,5,4,5,9}; 
		assertArrayEquals(expectedresult,sortedarr);
		
		
	}
	
	@Test
	public void fixXYTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.fixXY(new int[]{1,4,1,5}, 4, 5, 4);
		int []expectedresult=new int[]{1,4,5,1};
		assertArrayEquals(expectedresult,sortedarr);
		
	}
	
	@Test
	public void fixXYTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.fixXY(new int[]{1,4,1,5,5,4,1}, 4, 5, 7);
		int []expectedresult=new int[]{1,4,5,1,1,4,5};
		assertArrayEquals(expectedresult,sortedarr);		
	}
	
	@Test
	public void fixXYTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.fixXY(new int[]{1,4,4,5,5,4,1}, 4, 5, 7);
		int []expectedresult=new int[]{-1};
		assertArrayEquals(expectedresult,sortedarr);		
	}
	
	
	
	
	@Test
	public void getSplitArrayIndexTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.getSplitArrayIndex(new int[]{1,1,1,2,1}, 5);
		assertEquals(3,index);
		
	}
	
	@Test
	public void getSplitArrayIndexTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.getSplitArrayIndex(new int[]{2,1,1,2,1}, 5);
		assertEquals(-1,index);
		
	}
	
	@Test
	public void getSplitArrayIndexTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.getSplitArrayIndex(new int[]{10,10}, 2);
		assertEquals(1,index);
		
	}
	
	@Test(expected=AssertionError.class)
	public void getSplitArrayIndexTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.getSplitArrayIndex(new int[]{}, 0);
		//assertEquals(-2,index);	
	}
	
}
