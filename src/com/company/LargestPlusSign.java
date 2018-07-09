package com.company;
import java.util.Arrays;
// DP

/**
 * 764. Largest Plus Sign

 In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in
 the given list mines which are 0. What is the largest axis-aligned plus sign of 1s
 contained in the grid? Return the order of the plus sign. If there is none, return 0.

 An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with
 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated
 in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign,
 only the relevant area of the plus sign is checked for 1s.

 Examples of Axis-Aligned Plus Signs of Order k:

 Order 1:
 000
 010
 000

 Order 2:
 00000
 00100
 01110
 00100
 00000

 Order 3:
 0000000
 0001000
 0001000
 0111110
 0001000
 0001000
 0000000
 Example 1:

 Input: N = 5, mines = [[4, 2]]
 Output: 2
 Explanation:
 11111
 11111
 11111
 11111
 11011
 In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
 Example 2:

 Input: N = 2, mines = []
 Output: 1
 Explanation:
 There is no plus sign of order 2, but there is of order 1.
 Example 3:

 Input: N = 1, mines = [[0, 0]]
 Output: 0
 Explanation:
 There is no plus sign, so return 0.
 Note:

 N will be an integer in the range [1, 500].
 mines will have length at most 5000.
 mines[i] will be length 2 and consist of integers in the range [0, N-1].
 (Additionally, programs submitted in C, C++, or C# will be judged with a slightly smaller time limit.)

 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (mines==null || mines.length==0) return (N+1)/2;
        int[][] dp = new int[N][N];
        for (int[] d : dp) Arrays.fill(d, N);
        for (int[] mine : mines) dp[mine[0]][mine[1]]=0;

        for (int i=0; i<N; ++i){
            int l=0, r=0, u=0, d=0;
            for (int j=0, k=N-1; j<N; ++j, --k){
                dp[i][j] = Math.min(dp[i][j], l = (dp[i][j]==0 ? 0 : l+1));
                dp[i][k] = Math.min(dp[i][k], r = (dp[i][k]==0 ? 0 : r+1));
                dp[j][i] = Math.min(dp[j][i], u = (dp[j][i]==0 ? 0 : u+1));
                dp[k][i] = Math.min(dp[k][i], d = (dp[k][i]==0 ? 0 : d+1));
            }
        }
        int res = 0;
        for (int i=0; i<N; ++i){
            for (int j=0; j<N; ++j){
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
