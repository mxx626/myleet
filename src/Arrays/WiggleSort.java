package Arrays;
// TAG: Array, Sort
public class WiggleSort {
    /**
     *  Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

     For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        for (int i=1; i<nums.length; ++i){
            if (((i%2)==1 && nums[i-1]>nums[i])||(i%2==0 && nums[i]>nums[i-1])){
                swap(nums, i, i-1);
            }
        }
    }
    private void swap (int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
