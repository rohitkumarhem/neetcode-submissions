class Solution {
    public int leastInterval(char[] tasks, int n) {
        
      int count[] = new int[26];

      for(int x : tasks)
      {
        count[x-'A']++;
      }

      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

      for(int x : count)
      {
        if(x > 0)
        {
        pq.offer(x);
        }
      }
      
      Queue<int[]> q = new LinkedList<>();

       int t=0;

       while(!pq.isEmpty() || !q.isEmpty())
       {
           t++;

           if(pq.isEmpty())
           {
            t  = q.peek()[1];
           }
           else
           {
              int c = pq.poll()-1;
              if(c > 0)
              {
                q.add(new int[]{c, t+n});
              }
           }

           if(!q.isEmpty() && q.peek()[1] == t)
           {
            pq.add(q.poll()[0]);
           }
       }

       return t;

    }
}
