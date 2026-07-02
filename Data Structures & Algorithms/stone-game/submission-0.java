class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        int[][] dp = new int[n][n];
        
        // Step 3: Base cases (intervals of length 1)
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        
        // Loop through window lengths from 2 up to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Calculating the right boundary
                
                // Step 4 & 5: Take the best choice between left and right pick
                int pickLeft = piles[i] - dp[i + 1][j];
                int pickRight = piles[j] - dp[i][j - 1];
                
                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }
        
        // If the total game advantage for Alice is positive, she wins
        return dp[0][n - 1] > 0;
    }
    }
