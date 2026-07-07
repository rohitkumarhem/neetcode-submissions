class Solution {

    private static final int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        if(matrix==null || row==0 || col==0)
        return 0;

        int maxLen = 0;
        // memo[r][c] will store the length of the longest increasing path starting from cell (r, c)
        int [][]memo = new int[row][col];

      // Trigger a DFS from every single cell in the grid
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                int currLen = dfs(matrix, i, j, memo, row, col);
                maxLen = Math.max(maxLen, currLen);
            }
        }
    return maxLen;
        
}

int dfs(int [][]matrix, int r, int c, int [][]memo, int row, int col)
{
    // If the answer for this cell is already calculated, return it instantly
    if(memo[r][c]!=0)
    return memo[r][c];

// Every individual cell is inherently a valid path of length 1
    int maxFromHere = 1;

    for(int []d : dir)
    {
         int nxtR = r + d[0];
         int nxtC = c + d[1];

         if(nxtR>=0 && nxtR < row && nxtC>=0 && nxtC < col && 
         matrix[r][c] < matrix[nxtR][nxtC])
         {
            // Recursively find the path length from the neighbor and add 1 for the current step
            int len = 1 + dfs(matrix, nxtR, nxtC, memo, row, col);
            maxFromHere = Math.max(maxFromHere, len);
         }
    }

// Cache the optimal result for this cell before returning
    memo[r][c] = maxFromHere;
    return maxFromHere;
}
}
