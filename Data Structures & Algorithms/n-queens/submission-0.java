class Solution {

    public boolean isSafe(char [][]out, int c, int r, int n)
    {
        for(int i=0;i<n;i++)
        {
             if(out[i][c]=='Q')
             return false;
        }

        for(int i=r-1,j=c-1;i>=0 && j>=0; i--, j--)
        {
              if(out[i][j]=='Q')
              return false;
        }

        for(int i=r-1,j=c+1;i>=0 && j<n; i--,j++)
        {
            if(out[i][j]=='Q')
            return false;
        }

        return true;
    }

    public void solveit(int n, List<List<String>> res, char[][] out, int r)
    {
       if(r==n)
       {
           List<String> ls= new ArrayList<>();

           for(char[] ch : out)
           {
              ls.add(new String(ch));
           }

           res.add(ls);
           return;
       }

       for(int c=0;c<n;c++)
       {
          if(isSafe(out, c, r, n))
          {
            out[r][c] = 'Q';

            solveit(n, res, out, r+1);

            out[r][c] = '.';
          }
       }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] out = new char[n][n];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(out[i], '.');
        }

        solveit(n, res, out, 0);

        return res;

    }
}
