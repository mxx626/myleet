package Sort;
// Sort
/**
 * 324. Wiggle Sort II

 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example 1:

 Input: nums = [1, 5, 1, 1, 6, 4]
 Output: One possible answer is [1, 4, 1, 5, 1, 6].
 Example 2:

 Input: nums = [1, 3, 2, 2, 3, 1]
 Output: One possible answer is [2, 3, 1, 3, 1, 2].
 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    public int findKthLargest(int[] nums, int k) {
        int p = quickSelection(nums, 0, nums.length-1, k);
        return nums[p];
    }
    private int quickSelection(int[] nums, int s, int e, int k)
    {
        int i = s-1;
        int pivot = nums[e];
        for (int j = s; j<e; ++j)
        {
            if (nums[j]>=pivot)
            {
                i++;
                int tmp = nums[j];
                nums[j]=nums[i];
                nums[i]=tmp;
            }
        }
        int tmp1 = nums[++i];
        nums[i]= nums[e];
        nums[e] = tmp1;

        int m = i-s+1;
        if (m==k) return i;
        if (m>k) return quickSelection(nums, s, i-1, k);
        else return quickSelection(nums, i+1, e, k-m);
    }
    private void swap (int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
}
