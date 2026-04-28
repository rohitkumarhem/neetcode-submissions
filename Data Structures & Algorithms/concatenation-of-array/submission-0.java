class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int n = nums.length;

        int res[] = new int[2*n];
        int k=0;

        for(int i=0;i<n;i++) 
        {
            res[k++] = nums[i];
        }

        for(int i=0;i<n;i++)
        {
           res[k++] = nums[i];
        }

        return res;
        
    }
}