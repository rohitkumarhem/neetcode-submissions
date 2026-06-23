class Solution {
    public int numSquares(int n) {
        
        int dp[] = new int[n+1];

        dp[0] = 0;

        //To find the minimum number of perfect squares needed to 
        //sum up to i, we can look at the very last perfect 
        //square (j * j) we added to our sum. If we choose to 
        //include j * j, then our previous remaining sum must 
        //have been i - (j * j).
        //Our total count for that choice would be dp[i - (j * j)] + 1 
        //(the +1 represents using the current perfect square). 
        //We test all available perfect squares and pick the 
        //absolute minimum:
        //dp[i]=min(dp[i], dp[i-j*j]+1) for all j*j<=i

        for(int i=1;i<=n;i++)
        {
            int minSq = Integer.MAX_VALUE;

            for(int j=1;j*j<=i;j++)
            {
                int sq = j*j;
                minSq = Math.min(minSq, dp[i-sq]+1);
            }

            dp[i]= minSq;
        }

        return dp[n];
    }
}