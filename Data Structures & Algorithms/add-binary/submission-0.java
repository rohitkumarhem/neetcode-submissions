class Solution {
    public String addBinary(String a, String b) {

        StringBuilder str = new StringBuilder();

        int ai = a.length()-1;
        int bi = b.length()-1;

        int c=0;

        while(ai>=0 | bi>=0)
        {
            int sum = c;

            if(ai>=0)
            {
            sum+=a.charAt(ai)-'0';
            ai--;
            }

            if(bi>=0)
            {
                sum+=b.charAt(bi)-'0';
                bi--;
            }

            c = sum > 1 ? 1 : 0;

            str.append(sum%2);

        }

        if(c!=0)
        str.append(c);

        return str.reverse().toString();
    }
}