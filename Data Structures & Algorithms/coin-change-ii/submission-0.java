class Solution {
    public int change(int amount, int[] coins) {
        
        int []dp = new int[amount+1];

        dp[0] = 1;

        // Step 2: The Golden Rule — Loop through each coin ONE BY ONE on the outside loop.
        // This forces the computer to finish all possible paths using the current coin
        // BEFORE it can even touch the next coin. 
        // Result: Coins always appear in sorted order (e.g., 1+2), making 2+1 physically impossible to generate.

        for(int coin : coins)
        {
            // Step 3: Loop through all possible amounts starting from the value of the current coin.
            // Amounts smaller than the current coin cannot use this coin, so we safely start at 'i = coin'.
            for(int i=coin;i<=amount;i++)
            {
                // Step 4: The Core DP Transition Math.
                // To find the new total ways to make amount 'i', we combine two choices:
                // Choice A (dp[i]): Ways we already found using PREVIOUS coins (don't use this coin).
                // Choice B (dp[i - coin]): Ways to make the REMAINING amount if we DO use one copy of this coin.
                // We add them together to update our checklist.
                dp[i]+=dp[i-coin];
            }
        }

        return dp[amount];
    }
}
