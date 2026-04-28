class Solution {

      List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        backTrack(0, nums, new ArrayList<>());

        return res;

    }

    public void backTrack(int i, int []nums, List<Integer> ls)
    {
        res.add(new ArrayList<>(ls));

        for(int j=i;j<nums.length;j++)
        {
            if(j>i && nums[j]==nums[j-1])
            {
            continue;
            }

            ls.add(nums[j]);
            backTrack(j+1, nums, ls);
            ls.remove(ls.size()-1);

        }
    }
}
