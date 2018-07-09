package Greedy;
// Greedy, Heap
import java.util.HashMap;
import java.util.Map;

/**
 * 659. Split Array into Consecutive Subsequences
 *
 * You are given an integer array sorted in ascending order (may contain duplicates),
 * you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

 Example 1:
 Input: [1,2,3,3,4,5]
 Output: True
 Explanation:
 You can split them into two consecutive subsequences :
 1, 2, 3
 3, 4, 5
 Example 2:
 Input: [1,2,3,3,4,4,5,5]
 Output: True
 Explanation:
 You can split them into two consecutive subsequences :
 1, 2, 3, 4, 5
 3, 4, 5
 Example 3:
 Input: [1,2,3,4,4,5]
 Output: False
 */
public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if (nums==null || nums.length<3) return false;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> group = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0)+1);
        for (int num : nums){
            if (freq.get(num)==0) continue;
            if (group.getOrDefault(num, 0)>0){
                group.put(num, group.get(num)-1);
                group.put(num+1, group.getOrDefault(num+1, 0)+1);
            }
            else if (freq.getOrDefault(num+1, 0)>0 && freq.getOrDefault(num+2, 0)>0){
                freq.put(num+1, freq.getOrDefault(num+1, 0)-1);
                freq.put(num+2, freq.getOrDefault(num+2, 0)-1);
                group.put(num+3, group.getOrDefault(num+3, 0)+1);
            }
            else return false;
            freq.put(num, freq.getOrDefault(num, 0)-1);
        }
        return true;
    }
}
