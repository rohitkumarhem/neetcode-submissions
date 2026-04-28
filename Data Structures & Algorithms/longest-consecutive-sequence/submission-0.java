class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        int maxlen = 0;

          for(int i : nums)
          {
            set.add(i);
          }    

       for(int i : nums)
       {
         if(!set.contains(i-1))
         {
            int l = 1;

            while(set.contains(i+l))
            {
              l++;
            }

            maxlen = Math.max(maxlen, l);
         }
       } 

       return maxlen;

}
}
