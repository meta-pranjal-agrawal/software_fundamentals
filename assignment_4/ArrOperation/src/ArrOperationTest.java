import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrOperationTest 
{
	@Test
	public void MirrorTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.Mirror(new int[]{1,2,3,8,9,3,2,1}, 8);
		assertEquals(3,size);
		
	}
	
	@Test
	public void MirrorTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.Mirror(new int[]{7,1,4,9,7,4,1}, 7);
		assertEquals(2,size);
		
	}
	
	@Test
	public void MirrorTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.Mirror(new int[]{1,2,1,4},4);
		assertEquals(3,size);
	}

	@Test
	public void MirrorTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int size=arroperation.Mirror(new int[]{},0);
		assertEquals(-1,size);
	}
	
	
	@Test
	public void NumberofClumpsTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.NumberofClumps(new int[]{1,2,2,3,4,4},6);
		assertEquals(2,clumps);			
	}
	
	@Test
	public void NumberofClumpsTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.NumberofClumps(new int[]{1,1,2,1,1},5);
		assertEquals(2,clumps);
		
	}
	
	@Test
	public void NumberofClumpsTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.NumberofClumps(new int[]{1,1,1,1,1},5);
		assertEquals(1,clumps);
		
	} 
	
	@Test
	public void NumberofClumpsTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int clumps=arroperation.NumberofClumps(new int[]{},0);
		assertEquals(-1,clumps);			
	}
	
	
	@Test
	public void FixXYTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.FixXY(new int[]{5,4,9,4,9,5}, 4, 5, 6);
		int []expectedresult=new int[]{9,4,5,4,5,9}; 
		assertArrayEquals(expectedresult,sortedarr);
		
		
	}
	
	@Test
	public void FixXYTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.FixXY(new int[]{1,4,1,5}, 4, 5, 4);
		int []expectedresult=new int[]{1,4,5,1};
		assertArrayEquals(expectedresult,sortedarr);
		
	}
	
	@Test
	public void FixXYTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.FixXY(new int[]{1,4,1,5,5,4,1}, 4, 5, 7);
		int []expectedresult=new int[]{1,4,5,1,1,4,5};
		assertArrayEquals(expectedresult,sortedarr);		
	}
	
	@Test
	public void FixXYTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int []sortedarr=arroperation.FixXY(new int[]{1,4,4,5,5,4,1}, 4, 5, 7);
		int []expectedresult=new int[]{-1};
		assertArrayEquals(expectedresult,sortedarr);		
	}
	
	
	
	
	@Test
	public void SplitArrayTest1()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.SplitArray(new int[]{1,1,1,2,1}, 5);
		assertEquals(3,index);
		
	}
	
	@Test
	public void SplitArrayTest2()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.SplitArray(new int[]{2,1,1,2,1}, 5);
		assertEquals(-1,index);
		
	}
	
	@Test
	public void SplitArrayTest3()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.SplitArray(new int[]{10,10}, 2);
		assertEquals(1,index);
		
	}
	
	@Test
	public void SplitArrayTest4()
	{
		
		ArrOperation arroperation= new ArrOperation();
		int index=arroperation.SplitArray(new int[]{}, 0);
		assertEquals(-2,index);
		
	}
	
}
