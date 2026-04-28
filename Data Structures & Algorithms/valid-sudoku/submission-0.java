class Solution {
    public boolean isValidSudoku(char[][] board) {
        
    Set<String> res = new HashSet<>();

    int m = board.length;
    int n = board[0].length;

    for(int i=0;i<m;i++)
    {
       for(int j=0;j<n;j++)
       {
          if(board[i][j]!='.')
          {
            String str = "("+board[i][j]+")";

            if(!res.add(str+i) || !res.add(j+str) ||
            !res.add(i/3+str+j/3))
            return false;
          }
       }
    }

    return true;

    }
}
