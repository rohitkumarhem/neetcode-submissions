class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        if(arr==null || arr.length==0)
        return 0;

        if(arr.length==1)
        return 1;

        int maxLen = 1;
        int currLen = 1;
        int prevSign = 0; // -1 for '<', 1 for '>', 0 for equal/unset

      for(int i=0;i<arr.length-1;i++)
      {
          int currSign = Integer.compare(arr[i], arr[i+1]);

          if(currSign == 0)
          {
            // Elements are equal; reset length to 1
            currLen=1;
          }
          else if(currSign == -prevSign)
          {
            // Sign flipped successfully; extend the streak
            currLen++;
          }
          else
          {
            // Sign repeated or just started; reset to 2
            currLen = 2;
          }

          maxLen = Math.max(maxLen, currLen);
          prevSign = currSign;

      }

      return maxLen;
        
    }
}