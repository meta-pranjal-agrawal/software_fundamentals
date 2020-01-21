import java.util.Scanner;


public class NQueenProblem 
{
	
	 int [][] chessboard= new int[100][100];
	
	
	public boolean nQueen(int [][]board,int startRow,int dimensionOfMatrix)
	{
		chessboard=board;
		if(startRow==0)
		{
			return true;
		}
		
		for(int i=0; i<dimensionOfMatrix; i++)
		{
			for(int j=0; j<dimensionOfMatrix; j++)
			{
				if(!isAttack(chessboard,i,j,dimensionOfMatrix) && board[i][j]!=1)
				{
					chessboard[i][j]=1; 
					
					if(nQueen(chessboard,(startRow-1),dimensionOfMatrix)== true)
					{
						return true;
					}
					
					chessboard[i][j]=0;
						
				}
			}
		}
		
		
		return false;
	}

	public boolean isAttack(int [][]board,int row,int col,int dimensionOfMatrix)
	{
		chessboard=board;
		for(int k=0; k<dimensionOfMatrix; k++)
		{
			if(chessboard[row][k]==1 || chessboard[k][col]==1 )
				return true;
		}
		
		for(int k=0; k<dimensionOfMatrix; k++)
		{
			for(int l=0; l<dimensionOfMatrix; l++)
			{
				if((k+l) == (row+col) || (k-l) == (row-col))
					{
						if(chessboard[k][l]==1)
						{
							return true;
						}
					}
			}
		}
		
		
		return false;
	}
	
	public void print(int dimensionOfMatrix)
	{
		for(int i=0; i<dimensionOfMatrix; i++)
		{
			for(int j=0; j<dimensionOfMatrix; j++)
			{
				System.out.print(chessboard[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter the value of N");
		Scanner sc = new Scanner(System.in);
		int dimensionOfMatrix = sc.nextInt();
		int[][] matrix=new int[100][100];
		
		NQueenProblem nqueen = new NQueenProblem();
		boolean result = nqueen.nQueen(matrix,dimensionOfMatrix,dimensionOfMatrix);
		System.out.println(result);
		nqueen.print(dimensionOfMatrix);

	}

}
