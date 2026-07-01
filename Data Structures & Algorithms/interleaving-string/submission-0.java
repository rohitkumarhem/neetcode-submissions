class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length();
        int n = s2.length();

        if((m+n)!=s3.length())
        return false;

        if(m < n)
        return isInterleave(s2, s1, s3);

        boolean []dp = new boolean[n+1];
        dp[0] = true;

        // Base case: Initialize first row (when s1 is empty, only matching s2)
        for(int j=1;j<=n;j++)
        dp[j] = dp[j-1] && s2.charAt(j-1)==s3.charAt(j-1);

        for(int i=1;i<=m;i++)
        {
            // Update the first element of the row (when s2 is empty, only matching s1)
            dp[0]=dp[0] && s1.charAt(i-1) == s3.charAt(i-1);

            for(int j=1;j<=n;j++)
            {
                int k = i+j-1;

                // Condition 1: Match character from s1 (depends on previous row value 'dp[j]')
                boolean matchS1 = dp[j] && s1.charAt(i - 1) == s3.charAt(k);
                
                // Condition 2: Match character from s2 (depends on current row left neighbor 'dp[j-1]')
                boolean matchS2 = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k);
                
                dp[j] = matchS1 || matchS2;
            }
        }

        return dp[n];

    }
}
