package com.company;
// DP
public class BestTimetoBuyandSellStockwithCooldown {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete as many transactions as
     you like (ie, buy one and sell one share of the stock multiple times) with the following
     restrictions:

     You may not engage in multiple transactions at the same time (ie, you must sell the stock
     before you buy again).
     After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     Example:

     Input: [1,2,3,0,2]
     Output: 3
     Explanation: transactions = [buy, sell, cooldown, buy, sell]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0) return 0;
        int[] sell = new int[prices.length+1];
        int[] buy = new int[prices.length+1];
        int[] cool = new int[prices.length+1];
        buy[1] = -prices[0];
        for (int i=1; i<prices.length; ++i){
            sell[i+1]=buy[i]+prices[i];
            buy[i+1] = Math.max(buy[i], cool[i]-prices[i]);
            cool[i+1] = Math.max(sell[i],cool[i]);
        }
        return Math.max(sell[prices.length], cool[prices.length]);
    }

    public int maxProfit2(int[] prices) {
        if (prices==null || prices.length==0) return 0;
        int buy = Integer.MIN_VALUE;
        int cool = 0;
        int sell = 0;
        for (int  i : prices){
            int tmp = sell;
            sell = buy + i;
            buy = Math.max(buy, cool-i);
            cool = Math.max(tmp, cool);
        }
        return Math.max(sell, cool);
    }
}
