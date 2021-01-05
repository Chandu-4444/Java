import java.util.*;
import static java.lang.Math.*;
public class life 
{ 
	public static void main(String[] args) throws InterruptedException
	{ 
		int M = 10, N = 10; 

		// Intiliazing the grid. 
        int[][] grid = new int[10][10];
        
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(random()>0.5)
                {
                    grid[i][j] = 0;
                }
                else
                {
                    grid[i][j] = 1;
                }
            }
        }

		// Displaying the grid 
		System.out.println("Original Generation"); 
		for (int i = 0; i < M; i++) 
		{ 
			for (int j = 0; j < N; j++) 
			{ 
				if (grid[i][j] == 0) 
					System.out.print(" "); 
				else
					System.out.print("X"); 
			} 
			System.out.println(); 
        } 
        System.out.flush();
        Thread.sleep(100);
        for(int i=0;i<100;i++)
        {
		System.out.println(); 
        grid = nextGeneration(grid, M, N); 
        Print(grid);
        System.out.flush();
        Thread.sleep(300);
        }

        
	} 

	static int[][] nextGeneration(int grid[][], int M, int N) 
	{ 
		int[][] future = new int[M][N]; 

		for (int l = 1; l < M - 1; l++) 
		{ 
			for (int m = 1; m < N - 1; m++) 
			{ 
				int aliveNeighbours = 0; 
				for (int i = -1; i <= 1; i++) 
					for (int j = -1; j <= 1; j++) 
						aliveNeighbours += grid[l + i][m + j]; 

				aliveNeighbours -= grid[l][m]; 


				if ((grid[l][m] == 1) && (aliveNeighbours < 2)) 
					future[l][m] = 0; 

				else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) 
					future[l][m] = 0; 

				else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) 
					future[l][m] = 1; 

				else
					future[l][m] = grid[l][m]; 
            } 
            
        } 
        return future;
    }

    static void Print(int grid[][])
    {
        for(int i=0;i<10;i++)
        {
            System.out.print("--");
        }
        System.out.println();
		for (int i = 0; i < grid.length; i++) 
		{ 
			for (int j = 0; j < grid[i].length; j++) 
			{ 
				if (grid[i][j] == 0) 
					System.out.print(" "); 
				else
					System.out.print("X"); 
			} 
			System.out.println(); 
		} 
	} 
} 
