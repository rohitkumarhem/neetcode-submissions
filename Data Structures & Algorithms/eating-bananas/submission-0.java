class Solution {
    public int minEatingSpeed(int[] piles, int h) {

    int res = 0;
    int l = 1;
    int r = Arrays.stream(piles).max().getAsInt();

    while(l<=r)
    {
        int k = (l+r)/2;

        int tot=0;

        for(int x : piles)
        {
           tot+=Math.ceil((double)x/k);
        }

        if(tot<=h)
        {
            res = k;
            r=k-1;
        }
        else
        {
            l=k+1;
        }
    }

    return res;

    }
}
