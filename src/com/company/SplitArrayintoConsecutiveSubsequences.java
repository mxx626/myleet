package com.company;
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

 我们使用两个哈希表map，第一个map用来建立数字和其出现次数之间的映射freq，第二个用来建立可以加在某
 个连续子序列后的数字及其可以出现的次数之间的映射need。对于第二个map，举个例子来说，就是假如有个连
 ，[1,2,3]，那么后面可以加上4，所以就建立4的映射。这样我们首先遍历一遍数组，统计每个数字出现的频率
 ，然后我们开始遍历数组，对于每个遍历到的数字，首先看其当前出现的次数，如果为0，则继续循环；如果need
 中存在这个数字的非0映射，那么表示当前的数字可以加到某个连的末尾，我们将当前数字的映射值自减1，然后将
 下一个连续数字的映射值加1，因为当[1,2,3]连上4后变成[1,2,3,4]之后，就可以连上5了；如果不能连到其他
 子序列后面，我们来看其是否可以成为新的子序列的起点，可以通过看后面两个数字的映射值是否大于0，都大于0
 的话，说明可以组成3连儿，于是将后面两个数字的映射值都自减1，还有由于组成了3连儿，在need中将末尾的下
 一位数字的映射值自增1；如果上面情况都不满足，说明该数字是单牌，只能划单儿，直接返回false。最后别忘了
 将当前数字的freq映射值自减1。退出for循环后返回true

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
