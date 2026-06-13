class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
     int [][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

     int area = 0,maxArea = 0;

     Set<String> vis = new HashSet<>();

     int m = grid.length;
     int n = grid[0].length;

     for(int i=0;i<m;i++)
     {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==1 && !vis.contains(i+","+j))
            {
                area = bfsUtil(i,j,m,n,grid,dir,vis);

                maxArea = Math.max(maxArea, area);

            }
        }
     }

     return maxArea;

    }

    public int bfsUtil(int i, int j, int m,int n, int [][]grid, int [][]dir,
    Set<String> vis)
    {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{i,j});

        vis.add(i+","+j);
        int area = 0;

        while(!q.isEmpty())
        {
            int[]p = q.poll();
            int row = p[0];
            int col  = p[1];

            area++;

            for(int[] d : dir)
            {
                int nr  = d[0] + row;
                int nc = d[1] + col;

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 &&
                !vis.contains(nr+","+nc))
                {
                    vis.add(nr+","+nc);
                    q.add(new int[]{nr,nc});
                   
                }
            }
        }
        return area;
    }
}
