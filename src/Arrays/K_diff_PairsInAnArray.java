package Arrays;
// TAG: HashMap, Array, Two Pointer
import java.util.HashMap;
import java.util.Arrays;
public class K_diff_PairsInAnArray {
    /**
     * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs
     * in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both
     * numbers in the array and their absolute difference is k.

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
        if (k<0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (i!=0 && nums[i]==nums[i-1]) continue;
            if (k==0){
                if (map.get(nums[i])>=2){
                    count++;
                }
            }
            else if (map.containsKey(nums[i]+k)){
                count++;
            }
        }
        return count;
    }
    //fast
    public int findPairs2(int[] nums, int k) {
        if (nums==null || nums.length==0 || k<0) return 0;
        Arrays.sort(nums);
        int length=0;
        boolean isDuplicated=false;
        int duplicateCount=0;
        for (int i=1; i<nums.length; ++i){
            if (nums[i]!=nums[length]){
                nums[++length]=nums[i];
                isDuplicated=false;
            }
            else {
                if (!isDuplicated){
                    duplicateCount++;
                    isDuplicated=true;
                }
            }
        }
        if (k==0) return duplicateCount;
        int start=0, end=1;
        int pair=0;
        while (end<=length){
            if (nums[start]+k<nums[end]){
                start++;
            }
            else if (nums[start]+k>nums[end]){
                end++;
            }
            else {
                pair++;
                start++;
                end++;
            }
        }
        return pair;
    }
}
