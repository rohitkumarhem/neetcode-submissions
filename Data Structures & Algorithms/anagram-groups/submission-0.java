class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     
     List<List<String>> out = new ArrayList<>();
     Map<String,List<String>> mp = new HashMap<>();

   int n = strs.length;

    for(int i=0;i<n;i++)
    {
        char ch[] = strs[i].toCharArray();

        Arrays.sort(ch);

        String newstr = new String(ch);
        
        if(mp.containsKey(newstr))
        {
           mp.get(newstr).add(strs[i]);  
        }
        else
        {
            List<String> ls = new ArrayList<>();
            ls.add(strs[i]);
            mp.put(newstr, ls);
        }
    }

    for(String s : mp.keySet())
    {
        List<String> ls = mp.get(s);
        out.add(ls);
    }

    return out;

    }
}
