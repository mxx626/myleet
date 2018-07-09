package HashTable;
// TAG: HashTable, PreSum
import java.util.HashMap;

public class ContiguousArray {
    /**
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

     Example 1:
     Input: [0,1]
     Output: 2
     Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     Example 2:
     Input: [0,1,0]
     Output: 2
     Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     Note: The length of the given binary array will not exceed 50,000.
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res=0;
        int count1=0, count0=0;
        map.put(0,-1);
        for (int i=0; i<nums.length; ++i){
            if (nums[i]==1) count1++;
            else count0++;
            if (map.containsKey(count1-count0)){
                res = Math.max(res, i-map.get(count1-count0));
            }
            else map.put(count1-count0, i);
        }
        return res;
    }


    public int findMaxLength2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i){
            if (nums[i]==0) nums[i]=-1;
        }
        int res=0;
        int sum=0;
        map.put(0,-1);
        for (int i=0; i<nums.length; ++i){
            sum += nums[i];
            if (map.containsKey(sum)){
                res = Math.max(res, i-map.get(sum));
            }
            else map.put(sum, i);
        }
        return res;
    }
}
