class Solution {
    public List<List<Integer>> subsets(int[] nums) {

     List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());

        for(int x : nums)
        {
             int n = res.size();

             for(int i=0;i<n;i++)
             {
                List<Integer> ls = new ArrayList<>(res.get(i));

                ls.add(x);

                res.add(ls);
             }
        }

        return res;

    }
}
