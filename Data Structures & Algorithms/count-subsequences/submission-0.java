class Solution {
    public int numDistinct(String s, String t) {
        
        int m = s.length();
        int n = t.length();

// dp[i][j] stores matches for s[0...i-1] and t[0...j-1]
        int [][]dp= new int[m+1][n+1];

// Base case: empty t can always be formed (1 way)
        for(int i=0;i<=m;i++)
        {
            dp[i][0] = 1;
        }

        // Fill the matrix row by row

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    // Sum of matching the character + skipping it
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else
                {
                    // Must skip the character in s
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
