class Solution {
    public boolean isCheck(char ch)
    {
        return ((ch>='A' && ch<='Z') ||
                 (ch>='a' && ch<='z') ||
                 (ch>='0' && ch<='9'));
    }
    public boolean isPalindrome(String s) {
        
        int l=0, r= s.length()-1;

        while(l < r)
        {
           char lch = s.charAt(l);
           char rch = s.charAt(r);

           if(!isCheck(lch))
           {
              l++;
           }
           else if(!isCheck(rch))
           {
             r--;
           }
           else
           {
              if(Character.toLowerCase(lch)!=Character.toLowerCase(rch))
                 return false;

                 l++;
                 r--;
           }
        }

        return true;

    }
}
