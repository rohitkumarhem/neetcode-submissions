class Solution {
    public void reverseString(char[] s) {
        
        if(s.length==0)
        return;

        int l=0, h = s.length-1;

        while(l < h)
        {
           char temp = s[l];
           s[l] = s[h];
           s[h] = temp;

           l++;
           h--;
        }
    }
}