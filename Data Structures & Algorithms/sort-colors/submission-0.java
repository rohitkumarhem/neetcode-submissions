class Solution {

    public void swap(int []nums, int l, int h)
    {
        int temp = nums[l];
        nums[l] = nums[h];
        nums[h] = temp;
    }
    public void sortColors(int[] nums) {

    int low=0, mid=0, high=nums.length-1;

    while(mid<=high)
    {
        if(nums[mid]==0)
        {
            swap(nums, low, mid);
            low++;
            mid++;
        }
        else if(nums[mid]==1)
        {
           mid++;
        }
        else if(nums[mid]==2)
        {
            swap(nums, mid, high);
            high--;
        }
    }
    
    }
}