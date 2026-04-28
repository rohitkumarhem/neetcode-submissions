class Solution {
    public int numIslands(char[][] grid) {

     int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

      int m = grid.length;
      int n = grid[0].length;

      int c=0;

      Set<String> vis = new HashSet<>();

      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]=='1' && !vis.contains(i+","+j))
            {
                c++;
                bfsUtil(grid,i,j,m,n,vis, dir);
            }
        }
      }

      return c; 

    }

    public void bfsUtil(char[][] grid, int i, int j, int m,
    int n, Set<String> vis, int [][]dir)
    {
         Queue<int[]> que = new LinkedList<>();

         que.add(new int[]{i, j});

         vis.add(i+","+j);

         while(!que.isEmpty())
         {
            int[] p = que.poll();
            int row = p[0];
            int col = p[1];

            for(int []d : dir)
            {
                int nr = d[0] + row;
                int nc = d[1] + col;

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' && !vis.contains(nr+","+nc))
                {
                    vis.add(nr+","+nc);
                    que.add(new int[]{nr,nc});
                }
            }
         }
    }
}
