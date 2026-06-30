class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int totSum = 0;

        for(int x : nums)
        {
            totSum+=x;
        }

        if(Math.abs(target) > totSum)
        return 0;

      // Edge Case 2: (target + totalSum) must be even. 
        // If it's odd, dividing by 2 yields a decimal, which integers can't form.
        if((target+totSum)%2!=0)
        {
            return 0;
        }

        int subTarget = (target+totSum)/2;

        int []dp = new int[subTarget+1];

        dp[0]=1;

        for(int num : nums)
        {
            // Traverse BACKWARD to make sure we use each number exactly once
            for(int i=subTarget;i>=num;i--)
            {
                 // Total ways to make sum 'i' = ways without using 'num' (dp[i]) 
                //                            + ways using 'num' (dp[i - num])
                dp[i]+=dp[i-num];
            }
        }

        return dp[subTarget];

    }
}
