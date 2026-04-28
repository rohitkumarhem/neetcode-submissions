class Solution {
    public int maxAreaOfIsland(int[][] grid) {

       int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

       Set<String> vis = new HashSet<>();

       int m = grid.length;
       int n = grid[0].length;

       int area = 0;
       int maxArea = 0;

       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==1 && !vis.contains(i+","+j))
            {
               area = bfsUtil(grid,i,j,m,n,vis,dir);
               maxArea = Math.max(maxArea, area);
            }
        }
       }

       return maxArea;

    }


    public int bfsUtil(int [][]grid, int i, int j, int m, int n, Set<String> vis, int [][]dir)
    {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i,j});

        vis.add(i+","+j);

        int c=0;

        while(!q.isEmpty())
        {
            int []p = q.poll();
            int row = p[0];
            int col = p[1];

            c++;

            for(int[]d : dir)
            {
                int nr = d[0] + row;
                int nc = d[1] + col;

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && !vis.contains(nr+","+nc))
                {
                    vis.add(nr+","+nc);
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return c;
    }
}
