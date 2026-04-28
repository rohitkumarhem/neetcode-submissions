class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();

        if(s==null || s.length()==0)
        return "";
        
        int start = 0;
        int end = 1;

        for(int i=1;i<n;i++)
        {
            int l = i-1;
            int h = i;

            while(l>=0 && h<n && s.charAt(l)==s.charAt(h))
            {
                if(h-l+1 > end)
                {
                    end = h-l+1;
                    start = l;
                }    

                l--;
                h++;          
            }

            l = i-1;
            h = i+1;

            while(l>=0 && h < n && s.charAt(l)==s.charAt(h))
            {
                if(h-l+1 > end)
                {
                    end = h-l+1;
                    start = l;
                }

                
            l--;
            h++;
            }

        }

        return s.substring(start, start + end);

    }
}
