class Solution {

    public void mergeUtil(int[] nums, int l, int m, int h)
    {
    List<Integer> temp = new ArrayList<>();

      int i = l;
      int j = m+1;

      while(i <=m && j <= h)
      {
          if(nums[i]<=nums[j])
          {
             temp.add(nums[i]);
             i++;
          }
          else
          {
            temp.add(nums[j]);
            j++;
          }
      }

      while(i<=m)
      {
        temp.add(nums[i]);
        i++;
      }

      while(j<=h)
      {
        temp.add(nums[j]);
        j++;
      }

      for(i=l;i<=h;i++)
      {
        nums[i] = temp.get(i-l);
      }
    }

    public void sortUtil(int[] nums, int l, int h)
    {
        if(l>=h)
        return;

            int m = (l+h)/2;
            sortUtil(nums, l, m);
            sortUtil(nums, m+1, h);

             mergeUtil(nums, l, m, h);
    }
    public int[] sortArray(int[] nums) {
        
        sortUtil(nums, 0, nums.length-1);

        return nums;
    }
}