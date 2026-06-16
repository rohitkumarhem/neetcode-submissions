class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deadSet = new HashSet<>();

        Collections.addAll(deadSet, deadends);

        if(deadSet.contains("0000"))
        {
            return -1;
        }

        if(target.equals("0000"))
        return 0;

        Queue<String> q = new LinkedList<>();

        Set<String> vis = new HashSet<>();

        q.offer("0000");
        vis.add("0000");

        int turn=0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                String curr = q.poll();

                for(int j=0;j<4;j++)
                {
                    char []chars = curr.toCharArray();
                    char originalChar = chars[j];

                    for(int x : new int[]{-1, 1})
                    {
                        int nxt = (originalChar-'0'+x+10)%10;
                        chars[j] = (char)(nxt+'0');
                        String nextState = new String(chars);

                        if(nextState.equals(target))
                        return turn+1;

                        if(!deadSet.contains(nextState) && !vis.contains(nextState))
                        {
                            q.offer(nextState);
                            vis.add(nextState);
                        }
                    }

                    chars[j] = originalChar;

                }

            }

            turn++;
        }

        return -1;
}
}