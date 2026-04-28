class Solution {
    public int getSum(int a, int b) {

    while(b!=0)
    {
        int bit = (a & b) << 1;
         a^=b;
         b=bit;
    }
    
    return a;    
        
    }
}
