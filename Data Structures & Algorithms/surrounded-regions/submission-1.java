class Solution 
{
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){

            if(board[i][0]=='O')
            {
                board[i][0]='T';
                q.offer(new int[]{i,0});
            }
        }


         for(int i=0;i<m;i++)
         {
            if(board[i][n-1]=='O')
            {
                board[i][n-1]='T';
                q.offer(new int[]{i,n-1});
            }
         }

            for(int j=0;j<n;j++)
            {
                if(board[0][j]=='O')
                {
                    board[0][j]='T';
                    q.offer(new int[]{0,j});
                }
            }

             for(int j=0;j<n;j++)
            {
                if(board[m-1][j]=='O')
                {
                    board[m-1][j]='T';
                    q.offer(new int[]{m-1,j});
                }
            }

          bfsUtil(board, q);

          for(int i=0;i<m;i++)
          {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O')
                {
                board[i][j] = 'X';
                }
            else if(board[i][j]=='T')
            {
                    board[i][j]='O';
            }
          }
          }
    }

    public void bfsUtil(char [][]board, Queue<int[]> q)
    {

        int [][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int m = board.length;
        int n = board[0].length;

        while(!q.isEmpty())
        {
          int []curr = q.poll();
          int row = curr[0];
          int col = curr[1];

          for(int []d: dir)
          {
             int nr = row + d[0];
             int nc = col + d[1];

             if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O')
             {
                board[nr][nc]='T';
                q.offer(new int[]{nr, nc});
             }
          }
        }
    }
}

  

