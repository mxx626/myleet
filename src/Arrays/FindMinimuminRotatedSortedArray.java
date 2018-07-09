package Arrays;
// TAG: Arrays, Binary Search
public class FindMinimuminRotatedSortedArray {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     Find the minimum element.

     You may assume no duplicate exists in the array.
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int start=0, end=nums.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if (nums[mid]<=nums[start]&&nums[mid]>nums[end]){
                start=mid+1;
            }
            else if (nums[mid]>=nums[start]&&nums[mid]>nums[end]){
                start=mid+1;
            }
            else if (nums[mid]<=nums[start]&&nums[mid]<nums[end]){
                end=mid;
            }
            else if (nums[mid]>=nums[start]&&nums[mid]<nums[end]){
                end=mid;
            }
        }

        return nums[start];
    }

    public int findMin2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}
