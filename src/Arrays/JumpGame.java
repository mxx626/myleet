package Arrays;
// TAG: Array, Greedy
public class JumpGame {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if (n==1) return true;
        int max = n-1;
        for (int i=n-2; i>=0; --i){
            if (i+nums[i]>=max){
                max=i;
            }
            if (max==0) return true;
        }
        return false;
    }
}
