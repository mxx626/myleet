package Arrays;
// TAG: Array, Two Pointer
public class MergeSortedArray {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

     Note:
     You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
     additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m==0) {
            for (int i=0; i<n; i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        if (n==0) return;
        int p1=m-1, p2=n-1, len=m+n-1;
        while (p1>=0 || p2>=0){
            if (p1==-1){
                while(p2>=0) nums1[len--]=nums2[p2--];
                break;
            }
            if (p2==-1){
                while (p1>=0) nums1[len--]=nums1[p1--];
                break;
            }
            if (nums1[p1]>=nums2[p2]){
                nums1[len--]=nums1[p1--];
            }
            else if (nums1[p1]<nums2[p2]){
                nums1[len--] = nums2[p2--];
            }
        }
    }
    //Better
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1, p2=n-1, len=m+n-1;
        while (p1>=0 || p2>=0){
            if (p1>=0 && p2>=0){
                if (nums1[p1]>=nums2[p2]){
                    nums1[len]=nums1[p1--];
                }
                else nums1[len]=nums2[p2--];
            }
            else if (p1>=0){
                nums1[len]=nums1[p1--];
            }
            else {
                nums1[len]=nums2[p2--];
            }
            len--;
        }
    }
}
