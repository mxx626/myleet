package DP;
// DP
public class PaintHouseII {
    /**
     * There are a row of n houses, each house can be painted with one of the k colors. The cost of
     * painting each house with a certain color is different. You have to paint all the houses such t
     * hat no two adjacent houses have the same color.

     The cost of painting each house with a certain color is represented by a n x k cost matrix.
     For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the
     cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

     Note:
     All costs are positive integers.

     Example:

     Input: [[1,5,3],[2,9,4]]
     Output: 5
     Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
     Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
     Follow up:
     Could you solve it in O(nk) runtime?
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {
        if (costs==null || costs.length==0) return 0;
        int prevMin1=0, prevMin2=0, prevMinIdx=0;
        for (int i=0; i<costs.length; ++i){
            int tmpMin1=Integer.MAX_VALUE, tmpMin2=Integer.MAX_VALUE, idx=-1;
            for (int j=0; j<costs[0].length; ++j){
                int cost = costs[i][j] + ( (j==prevMinIdx) ? prevMin2 : prevMin1 );
                if (cost<tmpMin1){
                    tmpMin2=tmpMin1;
                    tmpMin1=cost;
                    idx=j;
                }
                else if (cost<tmpMin2){
                    tmpMin2=cost;
                }
            }
            prevMin1=tmpMin1;
            prevMin2=tmpMin2;
            prevMinIdx=idx;
        }
        return prevMin1;
    }
}
