package Arrays_and_Strings;

/**
 * Say you have an array prices for which the ith element is the price
 * of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as
 * many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStocks2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) {
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }
}
