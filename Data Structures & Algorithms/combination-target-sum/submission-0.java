class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        combineUtil(nums, target, res, 0, new ArrayList<>());

        return res;
    }

    public void combineUtil(int nums[], int target, List<List<Integer>> res,
    int s, List<Integer> ls)
    {
          if(target < 0)
          return;

          if(target == 0)
          {
             res.add(new ArrayList<>(ls));
          }

        else
        {
             for(int i=s;i<nums.length;i++)
             {
                ls.add(nums[i]);
                combineUtil(nums, target-nums[i], res, i, ls);
                ls.remove(ls.size()-1);
             }
        }

    }
}
