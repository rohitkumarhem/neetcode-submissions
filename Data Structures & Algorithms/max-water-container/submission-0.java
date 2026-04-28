class Solution {
    public int maxArea(int[] heights) {

      int l=0, h=heights.length-1;

      int res = Integer.MIN_VALUE;

      while(l < h)
      {
        int p = (h-l)*Math.min(heights[l], heights[h]);
             
             if(p > res)
             res = p;

             if(heights[l] < heights[h])
             {
                l++;
             }
             else
             {
                h--;
             }
      } 

      return res; 

    }
}
