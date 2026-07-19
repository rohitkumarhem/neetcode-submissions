class Solution {
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        int i;
        int count = 0;

        int []candies = new int[n];

        Arrays.fill(candies, 1);

        for(i=1;i<n;i++)
        {
            if(ratings[i] > ratings[i-1])
            {
               candies[i] = candies[i-1] + 1;
            }
        }

        for(i=n-1;i>0;i--)
        {
            if(ratings[i-1] > ratings[i])
            {
                candies[i-1] = Math.max(candies[i-1], candies[i] + 1); 
            }

            count+=candies[i];
        }

        count+=candies[i];

        return count;
    }
}