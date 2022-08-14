class Solution {
    public int maxProfit(int[] prices) {
        /*
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i=0; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = prices[i] - min;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
        */
        
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        int currProfit = 0;
        
        for(int i=0; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            currProfit = prices[i] - min;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}