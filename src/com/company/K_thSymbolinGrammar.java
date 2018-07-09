package com.company;
// Recursion
/**
 * 779. K-th Symbol in Grammar
 DescriptionHintsSubmissionsDiscussSolution
 On the first row, we write a 0. Now in every subsequent row, we look at the previous row
 and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

 Given row N and index K, return the K-th indexed symbol in row N. (The values of K are
 1-indexed.) (1 indexed).

 Examples:
 Input: N = 1, K = 1
 Output: 0

 Input: N = 2, K = 1
 Output: 0

 Input: N = 2, K = 2
 Output: 1

 Input: N = 4, K = 5
 Output: 1

 Explanation:
 row 1: 0
 row 2: 01
 row 3: 0110
 row 4: 01101001
 Note:

 N will be an integer in the range [1, 30].
 K will be an integer in the range [1, 2^(N-1)].
 */
public class K_thSymbolinGrammar {
    public int kthGrammar(int N, int K) {
        if (K==1) return 0;
        boolean flip = false;
        int len = (int)Math.pow(2, N-1);
        int res = K;
        while (len>2){
            if (res>len/2){
                flip = !flip;
                res = (res-len/2);
            }
            len/=2;
        }
        int[] arr = new int[3];
        arr[1]=0; arr[2]=1;
        return flip ? arr[res]^1 : arr[res];
    }


    public int kthGrammar2(int N, int K) {
        if (N == 1) return 0;
        if (K <= 1 << N-2)
            return kthGrammar2(N-1, K);
        return kthGrammar2(N-1, K - (1 << N-2)) ^ 1;
    }
}
