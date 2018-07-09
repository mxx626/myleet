package Arrays;
// TAG: Array, Sort
public class sortColor {
    /** Given an array with n objects colored red, white or blue, sort them so that objects of the same color
     * are adjacent, with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note:
     You are not suppose to use the library's sort function for this problem.

     click to show follow up.

     Follow up:
     A rather straight forward solution is a two-pass algorithm using counting sort.
     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total
     number of 0's, then 1's and followed by 2's.

     Could you come up with an one-pass algorithm using only constant space?
     * @param nums
     */
    public void sortColors(int[] nums) {
        int cur=0, ptr1=0, ptr2=nums.length-1;
        while (cur<=ptr2){
            if (nums[cur]==0){
                swap(nums, cur, ptr1);
                cur++;
                ptr1++;
            }
            else if (nums[cur]==1){
                cur++;
            }
            else if (nums[cur]==2){
                swap(nums, cur, ptr2);
                ptr2--;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
