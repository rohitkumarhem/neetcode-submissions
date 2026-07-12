class Solution {
    public int maxCoins(int[] nums) {

    int n = nums.length;
    int []ball = new int[n+2];

    ball[0] = 1;
    ball[n+1] = 1;

    for(int i=0;i<n;i++)
    ball[i+1] = nums[i];

    int [][]dp = new int[n+2][n+2];

    for(int len=1;len<=n;len++)
    {
        for(int i=1;i<=n-len+1;i++)
        {
            int j=i+len-1;

            for(int k=i;k<=j;k++)
            {
                int leftIntervalCoin = dp[i][k-1];

                int rightIntervalCoin = dp[k+1][j];

                int currentBallonCoin = ball[i-1]*ball[k]*ball[j+1];

                int totalCoin = leftIntervalCoin + rightIntervalCoin + 
                currentBallonCoin;

                dp[i][j] = Math.max(dp[i][j], totalCoin);
                 
            }
        }
    }

    return dp[1][n];
        
    }
}
