package HashTable;
// TAG: HashTable
import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk {
    /**
     * Given an array nums and a target value k, find the maximum length of
     * a subarray that sums to k. If there isn't one, return 0 instead.

     Note:
     The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

     Example 1:
     Given nums = [1, -1, 5, -2, 3], k = 3,
     return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

     Example 2:
     Given nums = [-2, -1, 2, 1], k = 1,
     return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

     Follow Up:
     Can you do it in O(n) time?
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> list = new HashMap<>();
        int sum=0;
        int res = 0;
        list.put(0, -1);
        for (int i=0; i<nums.length; ++i){
            sum += nums[i];
            if (list.containsKey(sum-k)){
                res = Math.max(res, i-list.get(sum-k));
            }
            if (!list.containsKey(sum)){
                list.put(sum, i);
            }
        }
        return res;
    }
}
