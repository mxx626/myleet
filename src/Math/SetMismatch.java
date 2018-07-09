package Math;
// Math, HashTable
/**
 * 645. Set Mismatch

 The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
 one of the numbers in the set got duplicated to another number in the set, which results in
 repetition of one number and loss of another number.

 Given an array nums representing the data status of this set after the error. Your task is
 to firstly find the number occurs twice and then find the number that is missing. Return them
 in the form of an array.

 Example 1:
 Input: nums = [1,2,2,4]
 Output: [2,3]
 Note:
 The given array size will in the range [2, 10000].
 The given array's numbers won't have any order.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int dup=0;
        for (int i=0; i<nums.length; ++i){
            int idx=Math.abs(nums[i])-1;
            if (nums[idx]<0) dup=idx+1;
            else
                nums[idx]=-nums[idx];
        }
        int miss=0;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]>0) {
                miss = i+1;
                break;
            }
        }
        return new int[]{dup, miss};
    }
}
