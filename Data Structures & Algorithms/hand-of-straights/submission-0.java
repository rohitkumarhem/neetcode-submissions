class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

       Map<Integer, Integer> mp = new HashMap<>();

       if(hand.length%groupSize != 0)
       return false;

       for(int x : hand)
       {
          mp.put(x, mp.getOrDefault(x, 0)+1);
       } 

       Arrays.sort(hand);

       for(int x: hand)
       {
          if(mp.get(x) > 0)
          {
            for(int i=x;i<x+groupSize;i++)
            {
                if(mp.getOrDefault(i,0) == 0)
                {
                    return false;
                }

                mp.put(i, mp.get(i)-1);
            }
          }
       }

       return true;
    }
}
