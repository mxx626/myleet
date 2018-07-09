package DP;
// DP
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 368. Largest Divisible Subset

 Given a set of distinct positive integers, find the largest subset such that
 every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] parent =new int[nums.length];
        int max = 0, index=0;
        for (int i=0; i<nums.length; ++i){
            count[i]=1;
            parent[i]=-1;
            for (int j=0; j<i; ++j){
                if (nums[i]%nums[j]==0 && 1+count[j]>count[i]){
                    count[i] = count[j]+1;
                    parent[i] = j;
                }
            }
            if (count[i]>max){
                max = count[i];
                index = i;
            }
        }
        while(index>=0){
            res.add(nums[index]);
            index = parent[index];
        }
        return res;
    }
}
