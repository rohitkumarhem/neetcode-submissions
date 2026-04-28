class Solution {
    public List<String> letterCombinations(String digits) {
        
         List<String> res = new ArrayList<>();

        if(digits==null || digits.length()==0)
        return res;
        
        Map<Character, String> mp = new HashMap<>();
         
         mp.put('2', "abc");
         mp.put('3',"def");
         mp.put('4',"ghi");
         mp.put('5',"jkl");
         mp.put('6',"mno");
         mp.put('7',"pqrs");
         mp.put('8',"tuv");
         mp.put('9',"wxyz");

         combUtil(digits, res, mp, 0, new StringBuilder());

         return res;

    }

    public void combUtil(String digits, List<String> res,
    Map<Character, String> mp, int idx, StringBuilder str)
    {
        if(idx==digits.length())
        {
            res.add(str.toString());
            return;
        }

        String x = mp.get(digits.charAt(idx));

        for(char m : x.toCharArray())
        {
            str.append(m);
            combUtil(digits, res, mp, idx+1, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
