class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        boolean [][]pacific = new boolean[m][n];
        boolean [][]atlantic = new boolean[m][n];

        List<List<Integer>> out = new ArrayList<>();
        Queue<int[]> qPac = new LinkedList<>();
        Queue<int[]> qAt = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
           pacific[i][0]=true;
           qPac.offer(new int[]{i,0}); 
        }

        for(int j=0;j<n;j++)
        {
            pacific[0][j]=true;
           qPac.offer(new int[]{0,j});
        }

        for(int i=0;i<m;i++)
        {
            atlantic[i][n-1]=true;
           qAt.offer(new int[]{i,n-1}); 
        }

        for(int j=0;j<n;j++)
        {
            atlantic[m-1][j]=true;
           qAt.offer(new int[]{m-1,j}); 
        }

        bfsUtil(heights, pacific, qPac);
        bfsUtil(heights, atlantic, qAt);

        for(int i=0;i<m;i++)
        {
        
            for(int j=0;j<n;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    out.add(Arrays.asList(i,j));
                }
            }
        }

        return out;
    }

        public void bfsUtil(int[][] heights, boolean [][]vis, Queue<int[]> q)
        {
            int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

            int m = heights.length;
            int n = heights[0].length;

            while(!q.isEmpty())
            {

                int []curr = q.poll();

                int row = curr[0];
                int col = curr[1];

                for(int []d : dir)
                {
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && 
                    !vis[nr][nc] && heights[nr][nc]>=heights[row][col])
                    {
                       vis[nr][nc] = true;
                       q.add(new int[]{nr, nc});
                    }
                } 
            }
        }

    }

