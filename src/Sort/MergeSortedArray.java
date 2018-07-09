package Sort;
// Sort
/**
 * 88. Merge Sorted Array

 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:

 The number of elements initialized in nums1 and nums2 are m and n respectively.
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 additional elements from nums2.
 Example:

 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]

 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=m; i<m+n; ++i){
            nums1[i] = nums2[i-m];
        }
        quickSort(nums1, 0, m+n-1);
    }

    private void quickSort(int[] num, int s, int e){
        if (s>=e) return;
        int pivot = num[e];
        int swap_pos = s-1;
        for (int i=s; i<e; ++i){
            if (num[i]<pivot){
                swap_pos++;
                int tmp = num[i];
                num[i] = num[swap_pos];
                num[swap_pos]=tmp;
            }
        }
        int tmp = num[++swap_pos];
        num[swap_pos]=num[e];
        num[e]=tmp;
        quickSort(num, s, swap_pos-1);
        quickSort(num, swap_pos+1, e);
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1;
        for (int k=m+n-1; k>=0; --k){
            if (i<0){
                nums1[k]=nums2[j--];
                continue;
            }
            if (j<0){
                nums1[k]=nums1[i--];
                continue;
            }
            if (nums1[i]>nums2[j]){
                nums1[k] = nums1[i--];
            }
            else nums1[k] = nums2[j--];

        }
    }
}
