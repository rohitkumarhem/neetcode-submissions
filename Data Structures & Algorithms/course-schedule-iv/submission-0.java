class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

       List<List<Integer>> graph = new ArrayList<>();
       int []indegree = new int[numCourses];

       for(int i=0;i<numCourses;i++)
       {
          graph.add(new ArrayList<>());
       } 

       for(int p[] : prerequisites)
       {
          int pre = p[0];
          int course = p[1];

          graph.get(pre).add(course);
          indegree[course]++;
       }


       boolean [][]isPre = new boolean[numCourses][numCourses];
       Queue<Integer> q = new LinkedList<>();

       for(int i=0;i<numCourses;i++)
       {
          if(indegree[i]==0)
          {
            q.offer(i);
          }
       }

       while(!q.isEmpty())
       {
          int curr = q.poll();

          for(int next : graph.get(curr))
          {
              isPre[curr][next] = true;

              for(int i=0;i<numCourses;i++)
              {
                if(isPre[i][curr])
                {
                    isPre[i][next]=true;
                }
              }
              
              indegree[next]--;

              if(indegree[next]==0)
              {
                q.offer(next);
              }  

          }
       }

    List<Boolean> ans = new ArrayList<>();

       for(int []query : queries)
       {
          ans.add(isPre[query[0]][query[1]]);
       }

       return ans;

    }
}