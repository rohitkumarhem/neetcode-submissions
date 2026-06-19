class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        int []parent = new int[n+1];

        for(int i=1;i<=n;i++)
        {
            parent[i]=i;
        }

        for(int []e : edges)
        {
            int u = e[0];
            int v = e[1];

            int rootu = find(parent, u);
            int rootv = find(parent, v);

            if(rootu==rootv)
            {
                return e;
            }

            parent[rootu]=rootv;
        }

        return new int[0];
    }

    int find(int []parent, int node)
    {
        if(parent[node]==node)
        return node;

        return parent[node]=find(parent, parent[node]);
    }
}
