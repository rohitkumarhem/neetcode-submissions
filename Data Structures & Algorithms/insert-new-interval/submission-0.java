class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      
      List<int[]> ls = new ArrayList<>(Arrays.asList(intervals));
      ls.add(newInterval);

      Collections.sort(ls, (a,b)-> Integer.compare(a[0], b[0]));

      List<int[]> res = new ArrayList<>();

      int prev[] = ls.get(0);

      for(int i=1;i<ls.size();i++)
      {
        int[] curr = ls.get(i);

        if(curr[0]<=prev[1])
        {
            prev[1] = Math.max(prev[1], curr[1]);
        }
        else
        {
            res.add(prev);
            prev=curr;
        }
      }

      res.add(prev);

      return res.toArray(new int[res.size()][]);

    }
}
