class Solution {
    public int lengthOfLongestSubstring(String s) {
         
         if(s.length()==0)
         return s.length();
         
      int len = Integer.MIN_VALUE;

      int l=0, r=s.length();
      int j=0;

      boolean flag[] = new boolean[256];
       
       while(l<r)
       {
         char ch = s.charAt(l);

         if(flag[ch])
         {
             while(flag[ch])
             {
                flag[s.charAt(j)]=false;
                j++;
             }
         }
         
         flag[ch] = true;
         len = Math.max(len, l-j+1);
         l++;

       }

       return len;

    }
}
