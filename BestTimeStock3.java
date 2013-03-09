public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length < 2) return 0;
        int profit = 0;
        
        
        //deal with prices
        int count = 0;
        for (int i = 0; i < prices.length-1; i++)
            if (prices[i] != prices[i+1]) ++count;
        ++count; 
        if (count > 4) {
            int [] newP = new int [count];
            count = 0;
            for (int i = 0; i< prices.length-1; i++)
                if (prices[i] != prices[i+1]) {
                    newP[count] = prices[i];
                    count++;
                }
            newP[count] = prices[prices.length-1];
            prices = newP;
        }
        
        int maximum = prices[prices.length-1];
        
        int [] m1 = new int [prices.length];
        Arrays.fill(m1, 0);
        
        
        // at most 1 transaction
        for (int i = prices.length-2; i >= 0; i--) {
            //if (prices[i] == prices[i+1]) continue;
            if (maximum < prices[i+1]) maximum = prices[i+1];
            if (m1[i] < maximum - prices[i]) m1[i] = maximum - prices[i];
            if (m1[i] > profit) profit = m1[i];
        }
        //at most 2 transactions
        for (int i = prices.length-4; i >= 0; i--) {
            //if (i < prices.length-4 && prices[i] == prices[i+1]) continue;
            for (int j = prices.length-1; j > i; j--) {
                //if (j < prices.length-1) 
                    //if (prices[j] == prices[j+1]) continue;
                for (int k = j-1; k > i; k--)
                {
                    //if (k < j-1) 
                        //if (prices[k] == prices[k+1]) continue;
                    if (prices[k]-prices[i]+m1[j] > profit)
                        profit = prices[k] - prices[i] + m1[j];
                }
            }
        }
        return profit;
    }
}
