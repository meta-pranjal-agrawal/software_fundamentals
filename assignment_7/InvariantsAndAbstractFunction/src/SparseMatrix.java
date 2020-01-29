
final public class SparseMatrix 
{
	 final int rowarr[];
	 final int colarr[];
	 final int valuesarr[];
	 final int size;
	 
	public SparseMatrix(int [][]matrix)
	{
		
		int k=0;
		int countNonZeroElements =0;
		size= matrix.length;
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if(matrix[i][j]!=0)
					countNonZeroElements++;
					
			}
		}
		
		
		this.rowarr = new int[countNonZeroElements];
		this.colarr = new int[countNonZeroElements];
		this.valuesarr = new int [countNonZeroElements];
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if(matrix[i][j]!= 0)
				{
					this.rowarr[k]= i;
					this.colarr[k]= j;
					this.valuesarr[k]= matrix[i][j];
					k++;
					
				}
			}
		}
		
	}
	
	/**
	 * 
	 * @return transpose of the matrix
	 */
	public int[][] getTranspose()
	{
		int []transposeRows = this.colarr.clone();
		int []transposeCols = this.rowarr.clone();
		
		if(transposeRows.length== 0 || transposeCols.length==0)
			return new int [][]{};
		
		int [][]transpose= new int[size][size];
		
		for(int i=0; i<this.rowarr.length; i++)
		{
			transpose[transposeRows[i]][transposeCols[i]] = this.valuesarr[i];
		}
		
		/*for(int i=0;i<transposeRows.length;i++)
		{
			for(int j=0;j<transposeCols.length;j++)
			{
				System.out.print(transpose[i][j]+" ");
			}
			System.out.println();
		}*/
		
		return transpose;
		
	}
	
	
	/**
	 * 
	 * @return true if the matrix is symmetric false otherwise
	 */
	public boolean isSymmetric()
	{
		int [][]matrix =new int[size][size]; 
		
		for(int i=0; i<this.rowarr.length; i++)
		{
			matrix[this.rowarr[i]][this.colarr[i]]=this.valuesarr[i];
			
		}
		
		if(matrix.length==0)
			return false;
		
		int [][]transposed = getTranspose();
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
			{
				if(matrix[i][j] != transposed[i][j])
					return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param object of sparsematrix
	 * @return addition of two matrices
	 */
	
	public int [][] add(SparseMatrix s)
	{
		int [][] matrix1= new int[size][size];
		int [][] matrix2= new int[size][size];
		
		if(size==0)
			return new int[][]{};
		
		int sum[][]=new int[size][size];
		
		for(int i=0; i<this.rowarr.length; i++)
		{
			matrix1[this.rowarr[i]][this.colarr[i]]=this.valuesarr[i];
			
		}
		for(int i=0; i<s.rowarr.length; i++)
		{
			matrix2[s.rowarr[i]][s.colarr[i]]=s.valuesarr[i];
		}
		
		//System.out.println("addition");
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				sum[i][j]=matrix1[i][j]+matrix2[i][j];
			}
		}
		
		/*for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}*/
		
		return sum;
	}
	
	
	/**
	 * 
	 * @param object of sparsematrix
	 * @return product of two matrices
	 */
	public int [][] multiply(SparseMatrix s)
	{
		int [][] matrix1= new int[size][size];
		int [][] matrix2= new int[size][size];
		
		if(size==0)
			return new int[][]{};
		
		for(int i=0; i<this.rowarr.length; i++)
		{
			matrix1[this.rowarr[i]][this.colarr[i]]=this.valuesarr[i];
			
		}
		for(int i=0; i<s.rowarr.length; i++)
		{
			matrix2[s.rowarr[i]][s.colarr[i]] = s.valuesarr[i];
		}
		
		int [][]multipliedMatrix= new int[size][size];
		
		//System.out.println("multiplication:");
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				for(int k=0; k<size; k++)
				{
					multipliedMatrix[i][j] += matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		
		/*for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(multipliedMatrix[i][j]+" ");
			}
			System.out.println();
		}*/
		
		
		return multipliedMatrix;
	}
		
	public static void main(String[] args)
	{
		
		int [][]matrix1= {{1,2,0},
						  {0,7,0},
						  {4,0,0}};
		
		SparseMatrix sparseMatrix1= new SparseMatrix(matrix1);
		
		int [][]matrix2= {{0,9,0,0},
				 		  {9,0,0,0},
				 		  {0,0,0,0},
				 		  {0,0,0,0}};
		
		SparseMatrix sparseMatrix2= new SparseMatrix(matrix2);
		
		
		int [][]transpose1= sparseMatrix1.getTranspose();
		System.out.println();
		
		int [][]transpose2= sparseMatrix2.getTranspose();
		System.out.println();
		
		
		boolean symmetry=sparseMatrix1.isSymmetric();
		System.out.println(symmetry);
		
		boolean symmetry1=sparseMatrix2.isSymmetric();
		System.out.println(symmetry1);
		
		int [][]sum=sparseMatrix1.add(sparseMatrix2);
		
		int [][]multipliedMatrix=sparseMatrix1.multiply(sparseMatrix2);
		
	} 

}
