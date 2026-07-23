class Solution {
    public int romanToInt(String s) {
        
        int n = s.length();
        int sum = 0;

        Map<Character, Integer> mp = new HashMap<>();

        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        for(int i = 0;i<n;i++)
        {
            if(i!=n-1 && mp.get(s.charAt(i)) < mp.get(s.charAt(i+1)))
            {
                sum-=mp.get(s.charAt(i));
            }
            else
            {
                sum+=mp.get(s.charAt(i));
            }
        }

        return sum;
    }
}