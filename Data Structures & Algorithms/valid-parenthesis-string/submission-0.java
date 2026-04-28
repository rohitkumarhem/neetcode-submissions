class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> l = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            l.push(i);

            else if(s.charAt(i)=='*')
            star.push(i);

           else
           {
              if(l.isEmpty() && star.isEmpty())
              return false;

              if(!l.isEmpty())
                 l.pop();

                 else
                 star.pop();
           } 
        }

        while(!l.isEmpty() && !star.isEmpty())
        {
           if(l.pop() > star.pop())
           return false;
        }

        return l.isEmpty();
    }
}
