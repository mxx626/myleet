package Arrays;
// TAG: HashMap, Array, Two Pointer
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i){
            int second = target-nums[i];
            if (map.containsKey(second)){
                return new int[]{map.get(second), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
//fast
    public int[] twoSum2(int[] nums, int target) {
        int numMin=Integer.MAX_VALUE, numMax=Integer.MIN_VALUE;
        for (int num : nums){
            if (num>numMax){
                numMax=num;
            }
            if (num<numMin){
                numMin=num;
            }
        }
        int targetMin = target-numMax;
        int targetMax = target-numMin;
        int start = numMin<targetMin ? numMin : targetMin;
        int end = numMax>targetMax ? numMax : targetMax;
        int[] arr = new int[end-start+1];
        Arrays.fill(arr, -1);
        for (int i=0; i<nums.length; ++i){
            if (arr[target-nums[i]-start]!=-1){
                return new int[]{arr[target-nums[i]-start], i};
            }
            else arr[nums[i]-start]=i;
        }
        return null;
    }
}
