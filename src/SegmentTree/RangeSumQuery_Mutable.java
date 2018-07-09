package SegmentTree;
// Segment Tree
/**
 * 307. Range Sum Query - Mutable

 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.

 Example:

 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:

 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQuery_Mutable {
    private int[] arr;
    private int[] seg_tree = new int[1];
    private int size = 0;;
    private int n;
    public RangeSumQuery_Mutable(int[] nums) {
        this.arr = nums;
        this.n = nums.length;
        int x = (int)Math.ceil(Math.log(nums.length)/Math.log(2));
        if (nums.length!=0){
            this.size = 2*(int)Math.pow(2, x)-1;
            this.seg_tree = new int[size];
            build(arr, 0, n-1, 0);
        }
    }
    private int build(int[] nums, int s, int e, int idx){
        if (s==e){
            seg_tree[idx]=nums[s];
            return seg_tree[idx];
        }
        int m = s+(e-s)/2;
        seg_tree[idx]=build(nums, s, m, 2*idx+1)+build(nums, m+1, e, 2*idx+2);
        return seg_tree[idx];
    }
    private int getSum (int start, int end, int qstart, int qend, int cur){
        if (qend>=end && qstart<=start) return seg_tree[cur];
        if (end<qstart || start>qend) return 0;
        int m = start+(end-start)/2;
        return getSum(start, m, qstart, qend, 2*cur+1)
                + getSum(m+1, end, qstart, qend, 2*cur+2);
    }

    public void update(int i, int val) {
        if (i<0 || i>size-1) return;
        int diff = val-arr[i];
        arr[i] = val;
        updateVal(0, n-1, i, diff, 0);
    }
    private void updateVal(int start, int end, int i, int diff, int cur){
        if (i<start || i>end) return;
        seg_tree[cur] = seg_tree[cur]+diff;
        if (end!=start){
            int mid = start+(end-start)/2;
            updateVal(start, mid, i, diff, 2*cur+1);
            updateVal(mid+1, end, i, diff, 2*cur+2);
        }
    }
    public int sumRange(int i, int j) {
        return getSum(0, n-1, i, j, 0);
    }
}
