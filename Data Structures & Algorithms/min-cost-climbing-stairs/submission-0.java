class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;

         int dp[] = new int[n+1];

         int i;

         for(i=0;i<n;i++)
         {
            if(i<2)
            {
                dp[i] = cost[i];
            }
            else
            {
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            }
         }

        return Math.min(dp[i-1], dp[i-2]);

    }
}
