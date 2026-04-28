class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<int[]> st = new Stack<>();

        int res[] = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++)
        {
           int x = temperatures[i];

           while(!st.isEmpty() && x > st.peek()[0])
           {
            int temp[] = st.pop();
            res[temp[1]] = i-temp[1];
           }

           st.push(new int[]{x, i});
        }

        return res;

    }
}
