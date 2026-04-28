class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int p = n-1;

        for(int i=n-1;i>=0;i--)
        {
             if(nums[i]+i>=p)
             p = i;
        }

        if(p > 0)
        return false;

        return true;

    }
}
