package com.company;
// TAG: Map, Binary Search
import java.util.HashMap;
import java.util.Map;

public class _4SumII {
    /**
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
     * there are such that A[i] + B[j] + C[k] + D[l] is zero.

     To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
     All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

     Example:

     Input:
     A = [ 1, 2]
     B = [-2,-1]
     C = [-1, 2]
     D = [ 0, 2]

     Output:
     2

     Explanation:
     The two tuples are:
     1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A){
            for (int b : B){
                int k = a+b;
                map.put(k, map.getOrDefault(k, 0)+1);
            }
        }
        int res=0;
        for (int c : C){
            for (int d : D){
                int k = -(c+d);
                res += map.getOrDefault(k, 0);
            }
        }
        return res;
    }
}
