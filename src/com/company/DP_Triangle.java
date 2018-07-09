package com.company;

import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 *  ]
 *  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *  Note:
 *  Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * i  :     j
 * i+1 :    j, j+1
 * dp=[4,1,8,3]
 * dp=[7,6,10]
 * dp=[9,10]
 * dp=[11]
 * **/
public class DP_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len+1];
        for (int i=triangle.size()-1; i>=0; --i){
            for (int j=0; j<triangle.get(i).size(); ++j){
                dp[j]=Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
