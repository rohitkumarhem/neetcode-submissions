class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices==null || prices.length<=1)
        return 0;

       int buyingState = -prices[0];
       int sellingState = 0;
       int coolDownState = 0;

       for(int i=1;i<prices.length;i++)
       {
           int prevBuy = buyingState;
           int prevSell = sellingState;
           int prevCoolDown = coolDownState;

           buyingState = Math.max(prevBuy, prevCoolDown-prices[i]);

           sellingState = Math.max(prevSell, prevBuy + prices[i]);

           coolDownState = prevSell;
       } 

       return sellingState;

    }
}
