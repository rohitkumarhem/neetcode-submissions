class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int dp[] = new int[target+1];

        dp[0] = 1;

        //To find how many ways we can reach a target i, 
        //we can look at the last number added to our sum. 
        //If the last number was num, then the previous sum must 
        //have been i - num.
        //dp[i] = sum(dp[i-num]) for all num <=i

        for(int i=1;i<=target;i++)
        {
            for(int num : nums)
            {
                if(i-num>=0)
                {
                dp[i] += dp[i-num];
                }
            }
        }

        return dp[target];
    }
}