class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }

        int len = 0;

        for(int x : set)
        {
           if(!set.contains(x-1))
           {
             int l=1;

              while(set.contains(x+l))
              {
                l++;
              }

              len = Math.max(len, l);
           } 
        }

        return len;
    }
}
