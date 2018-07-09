package DP;
// DP
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * 823. Binary Trees With Factors

 Given an array of unique integers, each integer is strictly greater than 1.

 We make a binary tree using these integers and each number may be used for any number of times.

 Each non-leaf node's value should be equal to the product of the values of it's children.

 How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.

 Example 1:

 Input: A = [2, 4]
 Output: 3
 Explanation: We can make these trees: [2], [4], [4, 2, 2]
 Example 2:

 Input: A = [2, 4, 5, 10]
 Output: 7
 Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].


 Note:

 1 <= A.length <= 1000.
 2 <= A[i] <= 10 ^ 9.

 */
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] A) {
        long res = 0L, mod = (long)Math.pow(10, 9)+7;
        Map<Integer, Long> dp = new HashMap<>();
        Arrays.sort(A);
        for (int i=0; i<A.length; ++i){
            dp.put(A[i], 1L);
            for (int j=0; j<i; ++j){
                if (A[i]%A[j]==0 && dp.containsKey(A[i]/A[j])){
                    dp.put(A[i], (dp.get(A[i])+dp.get(A[j])*dp.get(A[i]/A[j]))%mod);
                }
            }
        }
        for (Long val : dp.values()) res = (res+val)%mod;
        return (int)res;
    }
}
