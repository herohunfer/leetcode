public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length < 2) return 0;
        int profit = 0;
        int maximum = prices[prices.length-1];
        for (int i = prices.length-2; i >=0; i--) {
            if (maximum < prices[i+1]) maximum = prices[i+1];
            if (profit < maximum - prices[i]) profit = maximum - prices[i];
        }
        return profit;
    }
}
