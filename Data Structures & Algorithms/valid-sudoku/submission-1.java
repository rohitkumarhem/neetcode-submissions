class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> set = new HashSet<>();

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!='.')
                {
                String str = "(" + board[i][j] + ")";

                if(!set.add(str+i) || !set.add(j+str) || !set.add(i/3+str+j/3))
                {
                    return false;
                }

                }
            }
        }

        return true;
    }
}
