class Solution {
    public boolean validTree(int n, int[][] edges) {

    if(edges.length!=n-1)
    return false;

    int parent[] = new int[n];

    for(int i=0;i<n;i++)
    {
        parent[i]=i;
    }

    for(int[] e: edges)
    {
        int u = e[0];
        int v = e[1];

        int rootu = find(parent, u);
        int rootv = find(parent, v);

        if(rootu == rootv)
        return false;

        parent[rootu]=rootv;
    }

    return true;

    }

    int find(int parent[], int node)
    {
        if(parent[node]==node)
        return node;

        return parent[node]=find(parent, parent[node]);
    }
}
