package Arrays;
// TAG: Array
public class ShortestUnsortedContinuousSubarray {
    /**
     * Given an integer array, you need to find one continuous subarray that if you only sort
     * this subarray in ascending order, then the whole array will be sorted in ascending order, too.

     You need to find the shortest such subarray and output its length.

     Example 1:

     Input: [2, 6, 4, 8, 10, 9, 15]
     Output: 5
     Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

     Note:

     Then length of the input array is in range [1, 10,000].
     The input array may contain duplicates, so ascending order here means <=.

     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int start=-1, end=-1;
        int max = nums[0], min = nums[nums.length-1];
        for (int i=0; i<nums.length; ++i){
            if (nums[i]>=max){
                max = nums[i];
            }
            else end=i;
            if (nums[nums.length-1-i]<=min){
                min = nums[nums.length-1-i];
            }
            else start = nums.length-1-i;
        }
        if (start==-1) return 0;
        return end-start+1;
    }
}
