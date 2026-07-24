class Solution {
    public boolean validPalindrome(String s) {
        int c = 0;

        int l = 0, h = s.length()-1;

        while(l<h)
        {
            int lChar = s.charAt(l);
            int hChar = s.charAt(h);

                if(lChar!=hChar)
                {
                  return isPalindrome(s, l+1, h) || isPalindrome(s, l, h-1);
                }

                l++;
                h--;

        }

        return true;
    }

    public boolean isPalindrome(String s, int l, int h)
    {
        while(l < h)
        {
            int lChar = s.charAt(l);
            int hChar = s.charAt(h);

                if(lChar!=hChar)
                {
                  return false;
                }

                l++;
                h--;
        }

        return true;
    }
}