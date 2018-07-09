package DP;
// DP, Math
/**
 * 634. Find the Derangement of An Array

 In combinatorial mathematics, a derangement is a permutation of the elements
 of a set, such that no element appears in its original position.

 There's originally an array consisting of n integers from 1 to n in ascending
 order, you need to find the number of derangement it can generate.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 Example 1:
 Input: 3
 Output: 2
 Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].
 Note:
 n is in the range of [1, 106].


 */
public class FindtheDerangementofAnArray {
    public int findDerangement(int n) {
        if (n==1) return 0;
        long res = 1;
        long dpn_1 = 1;
        long dpn_2 = 0;
        for (int i=3; i<=n; ++i){
            res = ((i-1)*(dpn_1+dpn_2))%1000000007;
            dpn_2=dpn_1;
            dpn_1=res;
        }
        return (int)res;
    }
}
