class Solution {

    List<List<String>> res = new ArrayList<>();
    List<String> ls = new ArrayList<>();

    public List<List<String>> partition(String s) {
        
        dfs(0,s);
        
        return res;

    }

    public void dfs(int idx, String s)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList<>(ls));
        }

        for(int i = idx;i<s.length();i++)
        {
            if(isPalin(s, idx, i))
            {
                ls.add(s.substring(idx, i+1));
                dfs(i+1, s);
                ls.remove(ls.size()-1);
            }
        }
    }

    public boolean isPalin(String str, int s, int e)
    {
        while(s < e)
        {
            if(str.charAt(s++)!=str.charAt(e--))
            return false;

        }

        return true;
    }
}
