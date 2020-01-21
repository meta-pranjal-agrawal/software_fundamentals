import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrOperationTest 
{
	@Test
	public void mirrorTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.mirror(new int[]{1,2,3,8,9,3,2,1}, 8);
		assertEquals(3,size);
		
	}
	
	@Test
	public void mirrorTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.mirror(new int[]{7,1,4,9,7,4,1}, 7);
		assertEquals(2,size);
		
	}
	
	@Test
	public void mirrorTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.mirror(new int[]{1,2,1,4},4);
		assertEquals(3,size);
	}

	@Test(expected=AssertionError.class)
	public void mirrorTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.mirror(new int[]{},0);
		assertEquals(-1,size);
	}
	
	
	@Test
	public void numberOfClumpsTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.numberOfClumps(new int[]{1,2,2,3,4,4},6);
		assertEquals(2,clumps);			
	}
	
	@Test
	public void numberOfClumpsTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.numberOfClumps(new int[]{1,1,2,1,1},5);
		assertEquals(2,clumps);
		
	}
	
	@Test
	public void numberOfClumpsTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.numberOfClumps(new int[]{1,1,1,1,1},5);
		assertEquals(1,clumps);
		
	} 
	
	@Test(expected=AssertionError.class)
	public void numberOfClumpsTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.numberOfClumps(new int[]{},0);
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
	public void splitArrayTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.splitArray(new int[]{1,1,1,2,1}, 5);
		assertEquals(3,index);
		
	}
	
	@Test
	public void splitArrayTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.splitArray(new int[]{2,1,1,2,1}, 5);
		assertEquals(-1,index);
		
	}
	
	@Test
	public void splitArrayTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.splitArray(new int[]{10,10}, 2);
		assertEquals(1,index);
		
	}
	
	@Test(expected=AssertionError.class)
	public void splitArrayTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.splitArray(new int[]{}, 0);
		//assertEquals(-2,index);	
	}
	
}
