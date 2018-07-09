package com.company;
// TAG: Array,  Detect circle
public class FindtheDuplicateNumber {
    /**
     *  Given an array nums containing n + 1 integers where each integer is between 1 and n (
     *  inclusive), prove that at least one duplicate number must exist. Assume that there
     *  is only one duplicate number, find the duplicate one.

     Note:

     You must not modify the array (assume the array is read only).
     You must use only constant, O(1) extra space.
     Your runtime complexity should be less than O(n2).
     There is only one duplicate number in the array, but it could be repeated more than once.

     Credits:
     Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow==fast) break;
        }
        int finder=0;
        while (true){
            finder = nums[finder];
            slow = nums[slow];
            if (slow==finder) break;
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        int start=0, end = nums.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            int count=0;
            for (int n : nums){
                if (n<=mid) count++;
            }
            if (count<=mid) start=mid+1;
            else end=mid-1;
        }
        return start;
    }
}
