class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int count = n;
        int []parent = new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }

        for(int []e : edges)
        {
            int u = e[0];
            int v = e[1];

            int rootu = find(parent, u);
            int rootv = find(parent, v);

            if(rootu!=rootv)
            {
               parent[rootu]=rootv;
               count--;
            }
        }

        return count;
    }

    int find(int []parent, int node)
    {
        if(parent[node]==node)
        return node;

        return parent[node]=find(parent, parent[node]);
    }
}
