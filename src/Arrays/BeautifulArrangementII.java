package Arrays;
// TAG: Arrays
public class BeautifulArrangementII {
    /**
     * Given two integers n and k, you need to construct a list which contains n different positive
     * integers ranging from 1 to n and obeys the following requirement:
     Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... ,
     |an-1 - an|] has exactly k distinct integers.

     If there are multiple answers, print any of them.

     Example 1:
     Input: n = 3, k = 1
     Output: [1, 2, 3]
     Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1]
     has exactly 1 distinct integer: 1.
     Example 2:
     Input: n = 3, k = 2
     Output: [1, 3, 2]
     Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1]
     has exactly 2 distinct integers: 1 and 2.
     Note:
     The n and k are in the range 1 <= k < n <= 104.
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0]=1;
        int idx=1, end=n, start=2, flag=1;
        for (int i=k-1; i>0; --i){
            res[idx++] = flag==1 ? end-- : start++;
            flag = -flag;
        }

        for (int i=idx; i<n; ++i){
            res[i] = flag==1 ? start++ : end--;
        }
        return res;
    }
}
