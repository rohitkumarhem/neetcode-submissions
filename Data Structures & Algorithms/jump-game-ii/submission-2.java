class Solution {
    public int jump(int[] nums) {

        if(nums.length < 2)
        return 0;
        
        
        int currend = 0, farthest=0, jump=0;

        for(int i=0;i<nums.length;i++)
        {
            farthest = Math.max(farthest, i+nums[i]);

            if(i==currend)
            {
                jump++;
                currend = farthest;

                if(currend >= nums.length-1)
                break;
            }

        }

        return jump;
    }
}
