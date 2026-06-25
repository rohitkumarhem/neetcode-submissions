class Solution {
    public int integerBreak(int n) {

       int []dp = new int[n+1];

        dp[1] = 1;

        for(int i=2;i<=n;i++)
        {
            int maxProd = 0;

            for(int j=1;j<i;j++)
            {
                int op1 = j * (i-j);
                int op2 = j * dp[i-j];

                maxProd = Math.max(maxProd, Math.max(op1, op2));
            }

            dp[i] = maxProd;
        }

        return dp[n];
    }
}