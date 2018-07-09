package Arrays;
// Array
public class RotateArray {
    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.

     Example 1:

     Input: [1,2,3,4,5,6,7] and k = 3
     Output: [5,6,7,1,2,3,4]
     Explanation:
     rotate 1 steps to the right: [7,1,2,3,4,5,6]
     rotate 2 steps to the right: [6,7,1,2,3,4,5]
     rotate 3 steps to the right: [5,6,7,1,2,3,4]
     Example 2:

     Input: [-1,-100,3,99] and k = 2
     Output: [3,99,-1,-100]
     Explanation:
     rotate 1 steps to the right: [99,-1,-100,3]
     rotate 2 steps to the right: [3,99,-1,-100]
     Note:

     Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     Could you do it in-place with O(1) extra space?
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums==null || nums.length<2) return;
        k %= nums.length;
        swap (nums, 0, nums.length-k-1);
        swap (nums, nums.length-k, nums.length-1);
        swap (nums, 0, nums.length-1);
    }
    private void swap (int[] nums, int i, int j){
        while (i<j){
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            i++; j--;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums==null || nums.length<2) return;
        int count=0;
        for (int i=0; count<nums.length; ++i){
            int org = i;
            int pre = nums[org];
            do{
                int next = (i+k)%nums.length;
                int tmp  = nums[next];
                nums[next] = pre;
                pre = tmp;
                i = next;
                count++;
            }while(i!=org);
        }
    }
}
