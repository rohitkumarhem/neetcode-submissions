class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        permuteUtil(nums, res, new ArrayList<>());

        return res;
    }

    public void permuteUtil(int[] nums, List<List<Integer>> res,
    List<Integer> ls)
    {
          if(ls.size()==nums.length)
          {
            res.add(new ArrayList<>(ls));
          }
          else
          {
            for(int i=0;i<nums.length;i++)
            {
                if(ls.contains(nums[i]))
                {
                    continue;
                }

                ls.add(nums[i]);

                permuteUtil(nums, res, ls);

                ls.remove(ls.size()-1);
            }
          }
    }
}
