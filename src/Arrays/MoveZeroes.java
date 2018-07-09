package Arrays;
// TAG: Array, Two Pointer
public class MoveZeroes {
    /**
     * Given an array nums, write a function to move all 0's to the end of it
     * while maintaining the relative order of the non-zero elements.

     For example, given nums = [0, 1, 0, 3, 12], after calling your function,
     nums should be [1, 3, 12, 0, 0].

     Note:
     You must do this in-place without making a copy of the array.
     Minimize the total number of operations.
     Credits:
     Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums==null || nums.length==0) return;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]==0) continue;
            int j=i-1;
            while (j>=0 && nums[j]==0){
                j--;
            }
            int tmp = nums[j+1];
            nums[j+1]=nums[i];
            nums[i]=tmp;
        }
    }

    //Better
    public void moveZeroes1(int[] nums) {
        if (nums==null || nums.length==0) return;
        int ptr=0;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
    }
}
