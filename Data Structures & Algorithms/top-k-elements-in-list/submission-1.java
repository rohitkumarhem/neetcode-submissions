class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
      Map<Integer, Integer> mp = new HashMap<>();

      int []res = new int[k];

      for(int i=0;i<nums.length;i++)
      {
        mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
      }  

      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> 
      Integer.compare(b.getValue(), a.getValue()));

      for(Map.Entry<Integer, Integer> x : mp.entrySet())
      {
        pq.add(x);
      }

      for(int i=0;i<k;i++)
      {
          res[i] = Objects.requireNonNull(pq.poll()).getKey();
      }

   return res;

    }
}
