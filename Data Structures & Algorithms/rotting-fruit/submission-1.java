class Solution {
    public int orangesRotting(int[][] grid) {

      int [][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

      Queue<int[]> q = new LinkedList<>();

      int m = grid.length;
      int n = grid[0].length;
      int fresh = 0;

      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==1)
            {
                fresh++;
            }
            else if(grid[i][j]==2)
            {
               q.add(new int[]{i,j});
            }
        }
      }

    int mins=-1;

    while(!q.isEmpty())
    {
        int size = q.size();
        mins++;
     
     for(int k=0;k<size;k++)
     {
        int []p = q.poll();

        int r=p[0], c=p[1];

        for(int []d: dir)
        {
            int nr = d[0] + r;
            int nc = d[1] + c;

            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
            {
                grid[nr][nc]=2;
                fresh--;
                q.add(new int[]{nr, nc});
            }
        }

       
    }
    
    }
        return fresh==0 ? Math.max(mins, 0) : -1;
    }

   

}

