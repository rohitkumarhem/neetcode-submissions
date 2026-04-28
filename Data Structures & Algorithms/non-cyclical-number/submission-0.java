class Solution {
    public boolean isHappy(int n) {
        
        int sum;
        Set<Integer> set = new HashSet<>();
     
     while(n!=1)
     {
        sum=0;

     while(n > 0)
     {
        int x = n%10;
        sum += Math.pow(x, 2);
        n = n/10;
     }

      if(set.contains(sum))
      return false;

      set.add(sum);

      n=sum;
    
     }

     return true;
    }
}
