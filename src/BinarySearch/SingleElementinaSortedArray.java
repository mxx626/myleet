package BinarySearch;
// Binary Search
public class SingleElementinaSortedArray {
    /**
     * Given a sorted array consisting of only integers where every element
     * appears twice except for one element which appears once. Find this
     * single element that appears only once.

     Example 1:
     Input: [1,1,2,3,3,4,4,8,8]
     Output: 2
     Example 2:
     Input: [3,3,7,7,10,11,11]
     Output: 10
     Note: Your solution should run in O(log n) time and O(1) space.


     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while (i<j){
            int m = i+(j-i)/2;
            int n = m^1;
            if (nums[m]==nums[n]){
                i=m+1;
            }
            else j=m;
        }
        return nums[i];
    }
}
