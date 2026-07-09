class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();

// If one of the strings is empty, we must perform insertions/deletions equal to the other string's length
        if(m==0)
        return n;

        if(n==0)
        return m;

// dp array to track the minimum operations for the current row
        int []dp = new int[n+1];

// Base case initialization for the first row (converting empty word1 to word2 prefix)
        for(int j=0;j<=n;j++)
        dp[j]=j;

// Outer loop iterates through each character of word1
        for(int i=1;i<=m;i++)
        {
            int pre = dp[0];
            dp[0] = i;  // Base case for column 0 (converting word1 prefix to empty word2)
            for(int j=1;j<=n;j++)
            {
                // Temporarily cache the current value before it gets overwritten
                int temp = dp[j];

                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[j] = pre;
                } 
                else
                {
                    // If characters mismatch, find the minimum cost among:
                    // 1. Replace (pre)
                    // 2. Delete (dp[j] from the previous state of the same column)
                    // 3. Insert (dp[j-1] from the current row's previous column)
                    int replaceCost = pre;
                    int deleteCost = dp[j];
                    int insertCost = dp[j-1];

                    dp[j] = 1 + Math.min(replaceCost, Math.min(deleteCost, insertCost));

                }

                pre = temp;
            }
        }

        return dp[n];

    }
}
