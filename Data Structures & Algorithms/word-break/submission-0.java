class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        boolean dp[] = new boolean[n+1];

        dp[0]=true;

        for(int i=1;i<=n;i++)
        {
            for(String str : wordDict)
             {
                 int idx = i-str.length();

                 if(idx>=0 && dp[idx] && s.substring(idx, i).equals(str))
                 {
                    dp[i]=true;
                    break;
                 } 
             }
        }

        return dp[n];
    }
}
