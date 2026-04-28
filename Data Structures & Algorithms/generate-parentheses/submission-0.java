class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ls = new ArrayList<>();
        
        generateParenthesisUtil(ls, n, new StringBuilder(), 0, 0);

        return ls;

    }

    public void generateParenthesisUtil(List<String> ls, int n,
      StringBuilder str, int op, int cl)
    {
        if(2*n==str.length())
        {
            ls.add(str.toString());
        }

        if(op < n)
        {
            str.append("(");
            generateParenthesisUtil(ls, n, str, op+1, cl);
            str.setLength(str.length()-1);
        }

        if(cl < op)
        {
            str.append(")");
            generateParenthesisUtil(ls, n, str, op, cl+1);
            str.setLength(str.length()-1);
        }
    }
}
