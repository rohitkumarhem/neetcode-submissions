class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
       int max1 = Integer.MIN_VALUE;

       int sum = 0;

       for(int i=0;i<nums.length;i++)
       {
          sum += nums[i];

          if(sum > max1)
          {
             max1 = sum;
          }

          if(sum < 0)
          sum=0;

       }

       int tot = 0;
       for(int i=0;i<nums.length;i++)
       tot += nums[i];

// Trick: Max sum of an inverted array == Absolute Minimum sum of the original array.
       int min1 = Integer.MIN_VALUE;  // Will store the maximum sum of the INVERTED array
       sum = 0;

       for(int i=0;i<nums.length;i++)
       {
          sum+= nums[i]*(-1);

          if(sum > min1)
          min1 = sum;

          if(sum < 0)
          sum=0;
       }

       // Math Formula: Circular Max = Total Sum - Minimum Subarray Sum
        // Since min1 = -(Minimum Subarray Sum), the formula becomes:
        // Circular Max = tot - (-min1) = tot + min1

        min1 = tot + min1;

        // EDGE CASE: If all numbers in the array are negative numbers:
        // The minimum subarray will look like the entire array. 
        // Thus, tot + min1 will equal 0 (meaning the algorithm chose an empty subarray).
        // Since an empty subarray is illegal, we reject the 0 and return 'max1'

        if(min1 == 0)
        return max1;

        return Math.max(min1, max1);

    }
}