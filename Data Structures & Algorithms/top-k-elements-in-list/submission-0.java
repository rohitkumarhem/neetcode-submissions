class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    
    Map<Integer, Integer> mp = new HashMap<>();
    List<Integer> freq[]= new List[nums.length + 1];

    for(int i=0;i < freq.length;i++)
    {
        freq[i] = new ArrayList<>();
    }

    for(int i=0;i<nums.length;i++)
    {
       mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1); 
    }

    for(Map.Entry<Integer, Integer> m : mp.entrySet())
    {
        freq[m.getValue()].add(m.getKey());
    }

    int out[]= new int[k];
    int idx = 0;

    for(int i=freq.length-1;i > 0 && idx < k;i--)
    {
        for(int n : freq[i])
        {
            out[idx++] = n;
            if(idx == k)
            {
               return out;
            }
        }
    }

    return out;

    }
}
