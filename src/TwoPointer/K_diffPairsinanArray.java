package TwoPointer;
// Two Pointer
public class K_diffPairsinanArray {
    /**
     * Given an array of integers and an integer k, you need to find the number of unique k-diff
     * pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and
     * j are both numbers in the array and their absolute difference is k.

     Example 1:
     Input: [3, 1, 4, 1, 5], k = 2
     Output: 2
     Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     Although we have two 1s in the input, we should only return the number of unique pairs.
     Example 2:
     Input:[1, 2, 3, 4, 5], k = 1
     Output: 4
     Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
     Example 3:
     Input: [1, 3, 1, 5, 4], k = 0
     Output: 1
     Explanation: There is one 0-diff pair in the array, (1, 1).
     Note:
     The pairs (i, j) and (j, i) count as the same pair.
     The length of the array won't exceed 10,000.
     All the integers in the given input belong to the range: [-1e7, 1e7].

     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (nums==null || nums.length<1) return 0;
        quickSort(nums, 0, nums.length-1);
        int start = 0, end = 1, result = 0;
        while (start < nums.length && end < nums.length) {
            if (start == end || nums[start] + k > nums[end]) {
                end++;
            } else if (nums[start] + k < nums[end]) {
                start++;
            } else {
                start++;
                result++;
                while (start < nums.length && nums[start] == nums[start - 1]) start++;
                end = Math.max(end + 1, start + 1);
            }
        }
        return result;
    }
    private void quickSort (int[] num, int start, int end){
        if (start>=end) return;
        int pivot = num[end];
        int p = start-1;
        for (int i=start; i<end; ++i){
            if (num[i]<pivot){
                ++p;
                int tmp = num[p];
                num[p]=num[i];
                num[i]=tmp;
            }
        }
        int n = num[++p];
        num[p] = pivot;
        num[end]=n;
        quickSort(num, start, p-1);
        quickSort(num, p+1, end);
    }
}
