package Arrays;
// TAG: Array, Binary Search
public class SearchforaRange {
    /**
     * Given an array of integers sorted in ascending order, find the starting a
     * nd ending position of a given target value.

     Your algorithm's runtime complexity must be in the order of O(log n).

     If the target is not found in the array, return [-1, -1].

     For example,
     Given [5, 7, 7, 8, 8, 10] and target value 8,
     return [3, 4].


     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums==null || nums.length==0) return res;
        int start=-1, end=-1;
        int i=0, j=nums.length-1;
        while (i+1 < j){
            int m = i+(j-i)/2;
            if (nums[m]>=target) j=m;
            else {
                i=m;
            }
        }
        if (nums[i]==target) start=i;
        else if (nums[j]==target) start=j;
        if (start==-1) return res;

        i=0; j=nums.length-1;
        while (i+1<j){
            int m = i+(j-i)/2;
            if (nums[m]<=target) i=m;
            else j=m;
        }
        if (nums[j]==target) end=j;
        else if (nums[i]==target) end=i;
        res[0]=start;
        res[1]=end;
        return res;
    }
}
