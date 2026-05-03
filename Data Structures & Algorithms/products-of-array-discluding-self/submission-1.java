class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int []res = new int[n];
        int p=1;

        Arrays.fill(res, 1);

        for(int i=0;i<n;i++)
        {
             res[i]*=p;
             p*=nums[i]; 
        }

         p=1;

         for(int i=n-1;i>=0;i--)
         {
            res[i]*=p;
            p*=nums[i];
         }

         return res;
    }
}  
