package Arrays;
// TAG: Arrays
public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically
     * next greater permutation of numbers.

     If such arrangement is not possible, it must rearrange it as the lowest possible
     order (ie, sorted in ascending order).

     The replacement must be in-place, do not allocate extra memory.

     Here are some examples. Inputs are in the left-hand column and its corresponding
     outputs are in the right-hand column.
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length<2) return;
        int start=0;
        for (start=nums.length-1; start>=0; --start){
            if (start!=0 && nums[start]>nums[start-1]) {
                break;
            }
        }
        if (start==-1) {
            swapArray(nums, 0, nums.length-1);
            return;
        }
        start--;
        for (int i=nums.length-1; i>start; --i){
            if (nums[i]<=nums[start]) continue;
            else{
                int tmp = nums[start];
                nums[start]=nums[i];
                nums[i]=tmp;
                break;
            }
        }
        swapArray(nums, start+1, nums.length-1);
        return;
    }

    private void swapArray(int[] nums, int i, int j){
        while (i<=j){
            int tmp = nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
    }
}
