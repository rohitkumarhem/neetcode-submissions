class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int [][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0, area = 0;

        Set<String> vis = new HashSet<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !vis.contains(i+","+j))
                {
                    area = maxAreaUtil(grid, i, j, m, n, vis, dir);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;

    }

    int maxAreaUtil(int [][]grid, int i, int j, int m , int n, Set<String> vis, int [][]dir)
    {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});

        vis.add(i+","+j);
        int area = 0;

        while(!q.isEmpty())
        {
            int[] p = q.poll();
            int row = p[0];
            int col = p[1];

            area++;

            for(int []d : dir)
            {
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && !vis.contains(nr+","+nc))
                {
                    q.add(new int[]{nr,nc});
                    vis.add(nr+","+nc);
                }
            }
        }

        return area;
    }
}
