class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(int i=0;i<strs.length;i++)
        {
            String str = strs[i];
            char []arr = str.toCharArray();

            Arrays.sort(arr);

            String newStr = new String(arr);

            if(mp.containsKey(newStr))
            {
                mp.get(newStr).add(str);
            }
            else
            {
                List<String> ls = new ArrayList<>();
                ls.add(str);

                mp.put(newStr, ls);
            }
        }

        for(String x : mp.keySet())
        {
            List<String> ls = mp.get(x);
            res.add(ls);
        }

        return res;

    }
}
