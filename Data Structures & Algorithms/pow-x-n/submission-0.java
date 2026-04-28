class Solution {
    public double myPow(double x, int n) {

        if(x==0)
        return 0;

        if(n==0)
        return 1;

        double out = 1;
        long p = Math.abs((long)n);

        while(p > 0)
        {
            if((p & 1) == 1)
            {
                out*=x;
            }
            x*=x;
            p>>=1;
        } 

        return n>=0 ? out : 1/out; 
    }
}
