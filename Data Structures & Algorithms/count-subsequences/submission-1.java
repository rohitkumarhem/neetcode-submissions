class Solution {
    public int numDistinct(String s, String t) {
        
        int ls = s.length();
        int lt = t.length();
        
        // Edge case: if t is longer than s, it's impossible to form t
        if (lt > ls) {
            return 0;
        }
        
        // Space-optimized DP array
        int[] dp = new int[lt + 1];
        
        // Base case: an empty t can always be formed by 1 way (deleting all chars of s)
        dp[lt] = 1;
        
        // Traverse s from back to front
        for (int i = ls - 1; i >= 0; i--) {
            // Traverse t from front to back to safely use the previous row's state
            for (int j = 0; j < lt; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j] += dp[j + 1];
                }
            }
        }
        
        return dp[0];
    }
}
