package com.company;
// DP, BFS
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquare {
    /**
     * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

     Example 1:

     Input: n = 12
     Output: 3
     Explanation: 12 = 4 + 4 + 4.
     Example 2:

     Input: n = 13
     Output: 2
     Explanation: 13 = 4 + 9.

     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i=1; i<=n; ++i){
            dp[i]=Integer.MAX_VALUE;
            for (int j=1; j*j<=i; ++j){
                dp[i]=Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
    public int numSquares2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int step = 0;
        queue.offer(n);
        while (!queue.isEmpty()){
            int size = queue.size();
            step++;
            for (int i=0; i<size; ++i){
                int cur = queue.poll();
                if (!set.add(cur)) continue;
                for (int j=1; j*j<=cur; ++j){
                    int next = cur-j*j;
                    if (next==0) return step;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}
