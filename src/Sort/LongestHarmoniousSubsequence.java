package Sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
// Sort, HashTale
/**
 * 594. Longest Harmonious Subsequence

 We define a harmonious array is an array where the difference
 between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its
 longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int res = 0;
        for (Integer key : map.keySet()){
            if (map.containsKey(key+1)){
                res = Math.max(map.get(key)+map.get(key+1), res);
            }
        }
        return res;
    }
    public int findLHS2(int[] nums) {
        if (nums.length<2) return 0;
        Arrays.sort(nums);
        int count=0;
        int min = 0;
        for(int i=1; i<nums.length;){
            if (nums[i]==nums[min]) i++;
            else if (nums[i]==nums[min]+1){
                count = Math.max(count, i-min+1);
                i++;
            }
            else min++;
        }
        return count;
    }
}
