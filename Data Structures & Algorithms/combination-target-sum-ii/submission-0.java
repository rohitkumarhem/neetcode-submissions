class Solution {

    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

       res = new ArrayList<>();
       res.clear();
       Arrays.sort(candidates);

       combineUtil(candidates, target, 0, 0, new ArrayList<>());
       return res;

    }

    public void combineUtil(int []candidates, int target, int s, int sum,
    List<Integer> ls)
    {
        if(sum==target)
        {
            res.add(new ArrayList<>(ls));
        }

        for(int i=s;i<candidates.length;i++)
        {
            if(i > s && candidates[i]==candidates[i-1])
            {
                continue;
            }

            if(sum + candidates[i] > target)
            break;

            ls.add(candidates[i]);
            combineUtil(candidates,target,i+1, sum+candidates[i],
            ls);
            ls.remove(ls.size()-1);
        }
    }
}
