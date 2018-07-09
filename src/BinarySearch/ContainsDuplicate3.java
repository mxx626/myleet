package BinarySearch;
// Binary Search
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicate3 {
    /**
     * Given an array of integers, find out whether there are two distinct indices i
     * and j in the array such that the absolute difference between nums[i] and nums[j]
     * is at most t and the absolute difference between i and j is at most k.

     Example 1:

     Input: nums = [1,2,3,1], k = 3, t = 0
     Output: true
     Example 2:

     Input: nums = [1,0,1,1], k = 1, t = 2
     Output: true
     Example 3:

     Input: nums = [1,5,9,1,5,9], k = 2, t = 3
     Output: false

     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums==null || nums.length<2) return false;
        if (k<1 || t<0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        long diff = (long)t;
        for (int i=0; i<nums.length; ++i){
            if ((set.floor(nums[i])!=null && set.floor(nums[i])+diff>=nums[i]) ||
                    (set.ceiling(nums[i])!=null && set.ceiling(nums[i])<=diff+nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size()>k) set.remove(nums[i-k]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums==null || nums.length<=1 || k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> bucketToNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i] - (long) Integer.MIN_VALUE;
            long bucket = num/((long) t+1);
            if (bucketToNum.containsKey(bucket) ||
                    bucketToNum.containsKey(bucket-1) && num - bucketToNum.get(bucket-1) <= t ||
                    bucketToNum.containsKey(bucket+1) && bucketToNum.get(bucket+1) - num <= t) {
                return true;
            }
            if (bucketToNum.size() >= k) {
                long bucketToRemove = ((long) nums[i-k] - (long) Integer.MIN_VALUE)/((long) t+1);
                bucketToNum.remove(bucketToRemove);
            }
            bucketToNum.put(bucket, num);
        }
        return false;
    }
}
