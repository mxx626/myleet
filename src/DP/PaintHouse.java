package DP;
// DP
public class PaintHouse {
    /**
     *
     There are a row of n houses, each house can be painted with one of the three colors:
     red, blue or green. The cost of painting each house with a certain color is different.
     You have to paint all the houses such that no two adjacent houses have the same color.

     The cost of painting each house with a certain color is represented by a n x 3 cost
     matrix. For example, costs[0][0] is the cost of painting house 0 with color red;
     costs[1][2] is the cost of painting house 1 with color green, and so on... Find the
     minimum cost to paint all houses.

     Note:
     All costs are positive integers.

     Example:

     Input: [[17,2,17],[16,16,5],[14,3,19]]
     Output: 10
     Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
     Minimum cost: 2 + 5 + 3 = 10.
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0 || costs[0].length==0) return 0;
        int row = costs.length, col = costs[0].length;

        for (int i=row-2; i>=0; --i){
            for (int j=0; j<col; ++j){
                int tmp = costs[i][j];
                costs[i][j]=Integer.MAX_VALUE;
                for (int k=0; k<col; ++k){
                    if (k==j) continue;
                    costs[i][j]=Math.min(costs[i][j], costs[i+1][k]+tmp);
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for (int cost : costs[0]){
            res = Math.min(cost, res);
        }
        return res;
    }
}
