package Arrays;
// TAG: Array
/**
 *  Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product
 *  of all the elements of nums except nums[i]. Solve it without division and in O(n). For example, given [1,2,3,4],
 *  return [24,12,8,6].
 *  Follow up:
 *  Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the
 *  purpose of space complexity analysis.)
 *      1       2       3       4
 *      1       2       6       24
 * **/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums==null || nums.length==0) return res;
        res[0]=1;
        for (int i=1; i<nums.length; ++i){
            res[i]=res[i-1]*nums[i-1];
        }
        int right=1;
        for (int i=nums.length-1; i>=0; --i){
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }


    public int[] productExceptSelf1(int[] nums) {
        int[] output = new int[nums.length];
        int len = nums.length;
        output[0]=1;
        int right=nums[len-1];
        for (int i=1; i<nums.length; ++i){
            output[i] = output[i-1]*nums[i-1];
        }
        for (int i=nums.length-2; i>=0; --i){
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
