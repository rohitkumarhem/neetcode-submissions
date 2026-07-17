class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
         int n = s.length();
        // If the last character is '1', it can never be reached
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true; // Base case: starting point is always reachable

        int available = 0; // Tracks the count of reachable positions in the active window

        for (int i = 1; i < n; i++) {
            // 1. Add new element entering the window from the right side
            if (i >= minJump && dp[i - minJump]) {
                available++;
            }

            // 2. Remove old element exiting the window from the left side
            if (i > maxJump && dp[i - maxJump - 1]) {
                available--;
            }

            // 3. If there is at least one reachable index in our window and s[i] is '0'
            if (available > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}