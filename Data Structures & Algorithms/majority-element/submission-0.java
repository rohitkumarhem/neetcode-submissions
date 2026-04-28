class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> mp = new HashMap<>();
     int n = nums.length;
        
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        for(int x : mp.keySet())
        {
            int freq = mp.get(x);

            if(freq > n/2)
            return x;
        }

        return -1;

    }
}