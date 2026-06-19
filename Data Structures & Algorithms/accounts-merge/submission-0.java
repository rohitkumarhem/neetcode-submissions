class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> out = new ArrayList<>();
        int n = accounts.size();

        int parent[] = new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i] = i;
        }

        Map<String, Integer> emailToAcc = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            List<String> account = accounts.get(i);

            for(int j=1;j<account.size();j++)
            {
                String email = account.get(j);

                if(emailToAcc.containsKey(email))
                {
                   int prevAccIndex = emailToAcc.get(email);

                   int rootu = find(parent, i);
                   int rootv = find(parent, prevAccIndex);

                   if(rootu!=rootv)
                   {
                    parent[rootu]=rootv;
                   }
                }
                else
                {
                    emailToAcc.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> rootToEmail = new HashMap<>();

        for(String email : emailToAcc.keySet())
        {
            int accIndex = emailToAcc.get(email);

            int rootAccIndex = find(parent, accIndex);

            if(!rootToEmail.containsKey(rootAccIndex))
            {
                rootToEmail.put(rootAccIndex, new ArrayList<>());
            }

            rootToEmail.get(rootAccIndex).add(email);
        }

        for(int rootIndex : rootToEmail.keySet())
        {
            List<String> email = rootToEmail.get(rootIndex);

            Collections.sort(email);

            String name = accounts.get(rootIndex).get(0);

            List<String> mergedAcc = new ArrayList<>();

            mergedAcc.add(name);

            mergedAcc.addAll(email);

            out.add(mergedAcc);
        }

        return out;
    }

    int find(int []parent, int node)
    {
        if(parent[node]==node)
        return node;

        return parent[node]=find(parent, parent[node]);
    }
}