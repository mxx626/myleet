package Arrays;
// TAG: Array, DP
public class BestTimetoBuyandSellStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     If you were only permitted to complete at most one transaction (ie, buy one and sell one
     share of the stock), design an algorithm to find the maximum profit.

     Example 1:

     Input: [7, 1, 5, 3, 6, 4]
     Output: 5

     max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

     Example 2:

     Input: [7, 6, 4, 3, 1]
     Output: 0

     In this case, no transaction is done, i.e. max profit = 0.

     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2) return 0;
        int res=0, min=prices[0];
        for (int i=1; i<prices.length; ++i){
            if (prices[i]>min){
                res=Math.max(res, prices[i]-min);
            }
            else{
                min=prices[i];
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        //if (prices==null || prices.length<2) return 0;
        int max_end_here=0, max_so_far=0;
        for (int i=1; i<prices.length; ++i){
            max_end_here = Math.max(0, max_end_here += prices[i]-prices[i-1]);
            max_so_far = Math.max(max_so_far, max_end_here);
        }
        return max_so_far;
    }
}
