class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int profit = 0, buy = prices[0];

        for(int r = 1; r < prices.length; r++) {
            buy = Math.min(prices[r], buy);
            profit = Math.max(profit, prices[r] - buy);
        }

        return profit;
    }
}
