public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null) return 0;
        if (prices.length < 2) return 0;
        int [] buy = new int [prices.length];
        int [] sell = new int [prices.length];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        buy[0] = 0 - prices[0];
        sell[0] = Integer.MIN_VALUE;
        buy[1] = 0 - prices[1];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i-1]) continue;
            // 0 
            if (buy[0] + prices[i] > sell[i]) sell[i] = buy[0] + prices[i];
            for (int j = 1; j < i; j++) {
                if (sell[j] - prices[i] > buy[i]) buy[i] = sell[j] - prices[i];
                if (buy[j] + prices[i] > sell[i]) sell[i] = buy[j] + prices[i];
            }    
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++)
            if (sell[i] > profit) profit = sell[i];
        return profit;
    }
}
