class Solution {

    Boolean flag[][];
    public boolean canPartition(int[] nums) {
      
      int sum = 0;
      int n = nums.length;
      
      for(int x : nums)
      {
          sum+=x;
      }

      if(sum%2!=0)
      {
        return false;
      }

      int target = sum/2;
      flag = new Boolean[n][sum/2+1];
      
      return dfs(nums, 0, sum/2);
         
    }

    public boolean dfs(int[] nums, int i, int target)
    {
        if(i==nums.length)
        {
            return target==0;
        }

        if(target<0)
        {
            return false;
        }

        if(flag[i][target]!=null)
        return flag[i][target];

        flag[i][target] = dfs(nums, i+1, target) ||
                           dfs(nums, i+1, target-nums[i]);

           return flag[i][target];                
    }
}
