class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        Set<Integer> set = new HashSet<>();

        for(int[] x: triplets)
        {
              if(x[0]> target[0] || x[1]>target[1] || x[2]>target[2])
              continue;

              for(int i=0;i<target.length;i++)
              {
                  if(x[i]==target[i])
                  set.add(i);
              }
        }

        return set.size()==3;
    }
}
