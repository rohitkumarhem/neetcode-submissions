class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder str = new StringBuilder();

        int n1 = word1.length();
        int n2 = word2.length();
        int c=0, i=0, j=0;

        while(i < n1 || j < n2)
        {
          if(c%2==0 && i<n1)
          {
            str.append(word1.charAt(i));
            i++;
          }
          else if(j < n2)
          {
            str.append(word2.charAt(j));
            j++;
          }
          else if(i<n1)
          {
            str.append(word1.charAt(i));
            i++;
          }
          c++;
           
        }

        return str.toString();
    }
}