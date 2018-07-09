package TwoPointer;
// Two Pointer
public class LongestMountaininArray {
    /**
     * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

     B.length >= 3
     There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
     (Note that B could be any subarray of A, including the entire array A.)

     Given an array A of integers, return the length of the longest mountain.

     Return 0 if there is no mountain.



     Example 1:

     Input: [2,1,4,7,3,2,5]
     Output: 5
     Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
     Example 2:

     Input: [2,2,2]
     Output: 0
     Explanation: There is no mountain.
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        if (A==null || A.length==0) return 0;
        int res = 0, i=1;
        while (i<A.length-1){
            if (helper(A, i)<0) i++;
            else {
                int tmp = helper(A, i);
                res = Math.max(res, tmp);
                i += (tmp-1)/2+1;
            }
        }
        return res;
    }
    public int helper(int[] A, int start){
        if (start==A.length-1 || A[start]<=A[start+1]) return -1;
        else if (start==0 || A[start]<=A[start-1]) return -2;
        else if (A[start]<=A[start+1] && A[start]<=A[start-1]) return -3;
        int i=start, j=start;
        while (i-1>=0 || j+1<A.length){
            if ((i==0 || A[i-1]>=A[i]) && (j==A.length-1 || A[j+1]>=A[j])) break;
            if (i-1>=0 && A[i-1]<A[i]) i--;
            if (j+1<A.length && A[j+1]<A[j]) j++;
        }
        return j-i+1;
    }
    /////////////////////////// Solution 2
    public int longestMountain2(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i=1; i<A.length; ++i){
            if (down>0 && A[i-1]<A[i] || A[i-1]==A[i]) up=down=0;
            if (A[i-1]<A[i]) up++;
            if (A[i-1]>A[i]) down++;
            if (up>0 && down>0) res = Math.max(res, up+down+1);
        }
        return res;
    }
}
