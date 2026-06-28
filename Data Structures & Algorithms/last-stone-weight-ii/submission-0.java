class Solution {
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
         for(int x : stones)
         {
            sum+=x;
         } 

        
        int target = sum / 2;
        int maxSubsetSum = 0;

        boolean dp[] = new boolean[target+1];
        dp[0]=true; // Base case: A sum of 0 is always possible (empty subset)

        for(int stone : stones)
        {
            for(int s = target; s>=stone;s--)
            {
                // Traverse backward to ensure we only use each stone once (0/1 Knapsack rule)
                if(dp[s-stone])
                {
                    dp[s] = true;
                     // Track the largest sum we can form that is <= target
                    maxSubsetSum = Math.max(maxSubsetSum, s);
                }
            }
        }

        return sum - (2* maxSubsetSum);
    }
}