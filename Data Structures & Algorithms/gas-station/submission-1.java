class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int gasSum = 0, costSum = 0;

        for(int x : gas)
        gasSum+=x;

        for(int x : cost)
        costSum+=x;

        if(costSum > gasSum)
        return -1;

        int sum = 0, idx = 0;

        for(int i=0;i<gas.length;i++)
        {
            sum += gas[i] - cost[i];

            if(sum < 0)
            {
                idx  = i+1;
                sum = 0;
            }
        }

        return idx;
    }
}
