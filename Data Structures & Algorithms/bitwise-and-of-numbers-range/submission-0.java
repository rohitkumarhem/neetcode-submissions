class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
       // The bitwise AND of a range of numbers is equal to the common 
       //binary prefix shared by the start and end of that range.
        //Find the identical matching starting bits of left and right, 
        //and fill the rest with zeros.
        
        int shift  = 0;
        while(left < right)
        {
            left >>=1;
            right >>=1;
            shift++;
        }

        return left<<shift;
    }
}