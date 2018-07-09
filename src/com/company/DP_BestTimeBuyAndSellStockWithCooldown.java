package com.company;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * buy[i] 表示在第i天之前最后一个操作是买，此时的最大收益
 * sell[i] 表示在第i天之前最后一个操作是卖，此时的最大收益
 * rest[i] 表示在第i天之前最后一个操作是休息，此时的最大收益
 *
 * buy[i] = max(res[i-1]-price, buy[i-1]);
 * sell[i] = max(buy[i-1]+price, sell[i-1]);
 * rest[i] = max(buy[i-1], sell[i-1], rest[i-1]);
 *
 * 上述的递推式里如何保证(buy, rest, buy)不会出现，这是由于buy[i]<=rest[i], 即rest[i]=max(sell[i-1], rest[i-1])，这保证了这种情况不会出现。
 * 另外，由于冷冻期的出现，所以rest[i]=sell[i-1]。
 * buy[i]=max(sell[i-2]-price, buy[i-1]);
 * sell[i]=max(buy[i-1]+price, sell[i-1]);
 * **/
public class DP_BestTimeBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0) return 0;
        int len = prices.length;
        int sell = 0, prevSell=0;
        int buy = Integer.MIN_VALUE, prevBuy=0;
        for (int i=0; i<len; i++) {
            prevBuy = buy;
            buy = Math.max(prevSell-prices[i], prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy+prices[i], prevSell);
        }
        return sell;
    }
}
