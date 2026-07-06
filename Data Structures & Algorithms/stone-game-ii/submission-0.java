class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // Step 1: Compute Suffix Sums
        // suffixSum[i] stores the total number of stones from index i to the end of the array
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // Step 2: Initialize DP Table
        // dp[i][m] stores the maximum stones the current player can get 
        // starting at index 'i' with the current multiplier 'm'
        // Since X can be up to 2M, M can scale up to N. Size is N x (N + 1)
        int[][] dp = new int[n][n + 1];
        
        // Step 3: Populate DP table from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                
                // Shortcut Case: If the current player can take ALL remaining piles in one turn
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                    continue;
                }
                
                // Otherwise, test every choice of X from 1 to 2M
                int minOpponentStones = Integer.MAX_VALUE;
                for (int x = 1; x <= 2 * m; x++) {
                    // Opponent will start from index (i + x) with new M = max(m, x)
                    minOpponentStones = Math.min(minOpponentStones, dp[i + x][Math.max(m, x)]);
                }
                
                // Your score = Total remaining stones - Opponent's optimal stones from next turn
                dp[i][m] = suffixSum[i] - minOpponentStones;
            }
        }
        
        // Return Alice's score starting at index 0 with initial M = 1
        return dp[0][1];
    }
}