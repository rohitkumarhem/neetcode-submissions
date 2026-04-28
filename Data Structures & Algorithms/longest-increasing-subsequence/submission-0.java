class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;

        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);

        for(int i=1;i<n;i++)
        {
            if(ls.get(ls.size()-1) < nums[i])
            {
                ls.add(nums[i]);
            }
            else
            {
                int l = Collections.binarySearch(ls, nums[i]);

                if(l < 0)
                {
                    l = -(l+1);
                }

                ls.set(l, nums[i]);
            }
        }

        return ls.size();
    }
}
