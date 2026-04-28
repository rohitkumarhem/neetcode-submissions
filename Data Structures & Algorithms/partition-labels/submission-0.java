class Solution {
    public List<Integer> partitionLabels(String s) {
        
      Map<Character, Integer> mp = new HashMap<>();
      List<Integer> ls = new ArrayList<>();

       for(int i=0;i<s.length();i++)
         mp.put(s.charAt(i), i);
       
       int maxEnd = 0, c=0;

       for(int i=0;i<s.length();i++)
       {
           c++;
           maxEnd = Math.max(maxEnd, mp.get(s.charAt(i)));

           if(maxEnd == i)
           {
              ls.add(c);
              c=0;
           }
       }

       return ls;

    }
}
