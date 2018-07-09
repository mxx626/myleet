package Arrays;
// TAG: Arrays, Two Pointer
public class RemoveDuplicatedfromSortedArrayII {
    /**
     * Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?

     For example,
     Given sorted array nums = [1,1,1,2,2,3],

     Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
     It doesn't matter what you leave beyond the new length.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length<=2) return nums.length;
        int count=2;
        for (int i=2; i<nums.length; ++i){
            if (nums[i]!=nums[count-2]){
                nums[count++]=nums[i];
            }
        }
        return count;
    }
}
