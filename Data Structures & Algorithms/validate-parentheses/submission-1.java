class Solution {
    
    public boolean isCheck(char x, char y)
    {
       if(x=='(' && y==')')
       return true;

       else if(x=='{' && y=='}')
       return true;

       else if(x=='[' && y==']')
       return true;

       return false;

    }
    public boolean isValid(String s) {

      int n = s.length();
      Stack<Character> st = new Stack<>();

       for(int i=0;i<n;i++)
       {
           char ch = s.charAt(i);

           if(ch=='[' || ch == '{' || ch == '(')
           {
            st.push(ch);
           }
           else
           {
              if(!st.isEmpty() && isCheck(st.peek(), ch))
              {
                st.pop();
              }
              else
              {
                return false;
              }
           }
       }

       if(!st.isEmpty())
       return false;

       return true;

    }

}
