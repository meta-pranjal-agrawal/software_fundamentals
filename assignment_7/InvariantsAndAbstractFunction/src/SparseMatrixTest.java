import static org.junit.Assert.*;

import org.junit.*;



public class SparseMatrixTest 
{
	
	SparseMatrix sparseMatrix1;
	SparseMatrix sparseMatrix2;
	SparseMatrix sparseMatrix3;	
	
	@Before
	public void init()
	{
		int [][]matrix1= {{0,2,0,0},
				  		  {1,0,0,0},
				  		  {3,0,0,0},
				  		  {0,0,0,1}};

		sparseMatrix1=new SparseMatrix(matrix1);

		int [][]matrix2= {{0,9,0,0},
		 		  		  {9,0,0,0},
		 		  		  {0,0,0,0},
		 		  		  {0,0,0,0}};

		sparseMatrix2=new SparseMatrix(matrix2);
		
		int [][]matrix3= {};
		
		sparseMatrix3= new SparseMatrix(matrix3);
	}
	
	
	@Test
	public void getTransposeTest1()
	{
		
		int result[][]=sparseMatrix1.getTranspose();
		int [][]transpose={{0,1,3,0},
							{2,0,0,0},
							{0,0,0,0},
							{0,0,0,1}};
		
		assertArrayEquals(transpose,result);
	}
	
	
	@Test
	public void getTransposeTest2()
	{
		
		int result[][]=sparseMatrix3.getTranspose();
		int [][]transpose={};
		assertArrayEquals(transpose,result);
	}
	
	
	@Test
	public void addTest1()
	{
		int [][]result=sparseMatrix1.add(sparseMatrix2);
		int [][]expected={{0,11,0,0}, 
						  {10,0,0,0}, 
						  {3,0,0,0},
						  {0,0,0,1}};
		
		assertArrayEquals(expected,result);
	}
	
	
	@Test
	public void addTest2()
	{
		int [][]result=sparseMatrix3.add(sparseMatrix2);
		int [][]expected={};
		
		assertArrayEquals(expected,result);
	}
	
	@Test
	public void multiplyTest1()
	{
		
		int [][]result=sparseMatrix1.multiply(sparseMatrix2);
		int [][]expected={{18,0,0,0}, 
						  {0,9,0,0}, 
						  {0,27,0,0}, 
						  {0,0,0,0}};
		
		assertArrayEquals(expected,result);
	}
	
	@Test
	public void multiplyTest2()
	{
		
		int [][]result=sparseMatrix3.multiply(sparseMatrix2);
		int [][]expected={};
		
		assertArrayEquals(expected,result);
	}
	
	
	@Test
	public void isSymmetricTest1()
	{
		boolean result= sparseMatrix1.isSymmetric();
		assertEquals(false,result);
	}
	
	@Test
	public void isSymmetricTest2()
	{
		boolean result= sparseMatrix2.isSymmetric();
		assertEquals(true,result);
	}
	
}