class Solution {

    public String encode(List<String> strs) {
         
         StringBuilder b = new StringBuilder();

         for(String str : strs)
         {
            b.append(str.length()).append('#').append(str);
         }

         return b.toString();
    }

    public List<String> decode(String str) {

        int i=0, j;

        List<String> res = new ArrayList<>();

        while(i < str.length())
        {
            j=i;

            while(str.charAt(j)!='#')
            {
               j++;
            }

            int len = Integer.parseInt(str.substring(i,j));

            i=j+1;
            j=i+len;

            res.add(str.substring(i,j));
            i=j;
        }

        return res;

    }
}
