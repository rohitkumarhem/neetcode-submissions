class Solution {

    private static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {

       Queue<int[]> q = new LinkedList<>();

       int [][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

       int m = grid.length;
       int n = grid[0].length;

       for(int i=0;i<m;i++) 
       {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==0)
            {
                q.add(new int[]{i,j});
            }
        }
       }

         while(!q.isEmpty())
         {
            int []p = q.poll();
            int r = p[0];
            int c= p[1];
            
            for(int []d : dir)
            {
                int nr = d[0] + r;
                int nc = d[1] + c;

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==INF)
                {
                    grid[nr][nc] = grid[r][c] + 1;
                    q.add(new int[]{nr,nc});
                } 
            }

         
         }    

    }
}
