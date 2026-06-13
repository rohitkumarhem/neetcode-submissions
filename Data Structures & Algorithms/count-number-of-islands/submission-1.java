class Solution {
    public int numIslands(char[][] grid) {
        
        int [][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int c=0;

        int m = grid.length;
        int n = grid[0].length;

        Set<String> vis = new HashSet<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && !vis.contains(i+","+j))
                {
                    c++;
                    bfsUtil(i,j,m,n,grid,dir,vis);
                }
            }
        }
        return c;
    }

    public void bfsUtil(int i, int j, int m,int n, char [][]grid, int [][]dir, Set<String> vis)
    {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i,j});

        vis.add(i+","+j);

        while(!q.isEmpty())
        {
            int []p = q.poll();
            int row = p[0];
            int col = p[1];

            for(int []d : dir)
            {
                int nr = d[0]+row;
                int nc = d[1]+col;

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' 
                   && !vis.contains(nr+","+nc))
                   {
                     vis.add(nr+","+nc);
                     q.add(new int[]{nr,nc});
                   }
            }
        }


    }
}
