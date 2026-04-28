class Solution {
    public int findDuplicate(int[] nums) {
        
       for(int x : nums)
       {
          int idx = Math.abs(x) - 1;
            if(nums[idx] < 0)
            {
                return Math.abs(x);
            }

            nums[idx]*=-1;
       }

       return -1;

    }
}
