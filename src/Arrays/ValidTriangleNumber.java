package Arrays;
// TAG: Array, Two Pointer
import java.util.Arrays;
public class ValidTriangleNumber {
    /**
     * Given an array consists of non-negative integers, your task is to count the number
     * of triplets chosen from the array that can make triangles if we take them as side
     * lengths of a triangle.
     Example 1:
     Input: [2,2,3,4]
     Output: 3
     Explanation:
     Valid combinations are:
     2,3,4 (using the first 2)
     2,3,4 (using the second 2)
     2,2,3
     Note:
     The length of the given array won't exceed 1000.
     The integers in the given array are in the range of [0, 1000].

     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for (int i=2; i<nums.length; ++i){
            //   if (nums[i]==0) continue;
            int j=0, k=i-1;
            while (j<k){
                if (nums[j]+nums[k]>nums[i]){
                    count += k-j;
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return count;
    }
}
