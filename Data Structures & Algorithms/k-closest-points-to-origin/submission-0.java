class Solution {
    public int[][] kClosest(int[][] points, int k) {

       PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(
         b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]));


         for(int[] x : points)
         {
            pq.offer(x);

            if(pq.size() > k)
            pq.poll();

         } 

        int[][] res= new int[k][2];
        int i=0;

      while(pq.size() > 0)
      {
         res[i++] = pq.poll();
      } 
        
      return res;

    }
}
