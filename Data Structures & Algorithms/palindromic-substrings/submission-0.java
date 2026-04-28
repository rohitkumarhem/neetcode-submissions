class Solution {
    
    public int countUtil(int l, int h, String str)
    {
        int n = str.length();
        int count=0;

          while(l>=0 && h<n && str.charAt(l)==str.charAt(h))
          {
              l--;
              h++;
              count++;
          }

          return count;
    }
    public int countSubstrings(String s) {
         
         int count = 0;

         for(int i=0;i<s.length();i++)
         {
            count+=countUtil(i ,i ,s)+countUtil(i, i+1, s);
         }

        return count; 
    }
}
