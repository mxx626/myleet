package com.company;
// DFS
public class MatchstickstoSquare {
    /**
     * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the
     * little match girl has, please find out a way you can make one square by using up all
     * those matchsticks. You should not break any stick, but you can link them up, and each
     * matchstick must be used exactly one time.

     Your input will be several matchsticks the girl has, represented with their stick length.
     Your output will either be true or false, to represent whether you could make one square
     using all the matchsticks the little match girl has.

     Example 1:
     Input: [1,1,2,2,2]
     Output: true

     Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
     Example 2:
     Input: [3,3,3,3,4]
     Output: false

     Explanation: You cannot find a way to form a square with all the matchsticks.
     Note:
     The length sum of the given matchsticks is in the range of 0 to 10^9.
     The length of the given matchstick array will not exceed 15.

     * @param nums
     * @return
     */
    public boolean makesquare(int[] nums) {
        if (nums==null || nums.length<4) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 4!=0) return false;
        boolean[] visit = new boolean[nums.length];
        return helper(nums, 0, visit, sum/4, 0, 0);
    }
    private boolean helper(int[] nums, int start, boolean[] visit, int target, int sum, int count){
        if (count==4) return true;
        if (sum==target){
            count++;
            return helper(nums, 0, visit, target, 0, count);
        }
        for (int i=start; i<nums.length; ++i){
            if(!visit[i] && sum+nums[i]<=target){
                visit[i]=true;
                if (helper(nums, i+1, visit, target, sum+nums[i], count)) return true;
                visit[i]=false;
            }
        }
        return false;
    }
}
