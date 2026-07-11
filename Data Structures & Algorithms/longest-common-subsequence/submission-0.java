class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

        // dp[i][j] stores the length of the LCS for prefixes text1[0...i-1] and text2[0...j-1]

        int [][]dp = new int[m+1][n+1];

        // Base cases: If either string is empty, the LCS length is 0.
        // Java automatically initializes the array with 0s, satisfying this condition.

        // Fill the grid using the state transition rules

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                // Case 1: If the characters match perfectly
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    // Add 1 to the optimal result of the remaining prefixes (diagonal step)
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    // Skip the current character of text1 OR skip the current character of text2
                    // and choose the option that yields the longer subsequence
                    int skipText1 = dp[i-1][j];
                    int skipText2 = dp[i][j-1];

                    dp[i][j] = Math.max(skipText1, skipText2);
                }
            }
        }

        return dp[m][n];
    }
}
