class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();

  // dp[i][j] will store the minimum operations to convert word1[0...i-1] to word2[0...j-1]
        int [][]dp = new int[m+1][n+1];

        // Step 1: Initialize the Base Cases for Rows and Columns
        // If word2 is empty, we must delete all characters from word1
        for(int i=0;i<=m;i++)
        {
           dp[i][0]=i;
        }
        // If word1 is empty, we must insert all characters of word2

        for(int j=0;j<=n;j++)
        {
            dp[0][j]=j;
        }

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    int replaceCost = dp[i-1][j-1];
                    int deleteCost = dp[i-1][j];
                    int insertCost = dp[i][j-1];

                    dp[i][j] = 1 + Math.min(replaceCost, 
                    Math.min(deleteCost, insertCost));
                }
            }
        }

        return dp[m][n];
    }
}
