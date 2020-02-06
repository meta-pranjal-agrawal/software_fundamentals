import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.*;
import org.junit.Test;

public class NQueenTest 
{
	@Test
	public void nQueenTest1()
	{
		NQueenProblem nqueen = new NQueenProblem();
		int dimensions=2;
		int [][] matrix=new int[100][100];
		boolean result=nqueen.nQueen(matrix,dimensions,dimensions);
		assertEquals(false,result);
	}
	
	
	@Test
	public void nQueenTest2()
	{
		NQueenProblem nqueen = new NQueenProblem();
		int dimensions=3;
		int [][] matrix=new int[100][100];
		boolean result=nqueen.nQueen(matrix,dimensions,dimensions);
		assertEquals(false,result);
	}
	
	
	@Test
	public void nQueenTest3()
	{
		NQueenProblem nqueen = new NQueenProblem();
		int dimensions=4;
		int [][] matrix=new int[100][100];
		boolean result=nqueen.nQueen(matrix,dimensions,dimensions);
		assertEquals(true,result); 
	}
	
	@Test
	public void nQueenTest4()
	{
		NQueenProblem nqueen = new NQueenProblem();
		int dimensions=5;
		int [][] matrix=new int[100][100];
		boolean result=nqueen.nQueen(matrix,dimensions,dimensions);
		assertEquals(true,result);
	}

}