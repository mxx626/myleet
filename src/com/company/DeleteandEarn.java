package com.company;
// DP
public class DeleteandEarn {
    /**
     * Given an array nums of integers, you can perform operations on the array.

     In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

     You start with 0 points. Return the maximum number of points you can earn by applying such operations.

     Example 1:
     Input: nums = [3, 4, 2]
     Output: 6
     Explanation:
     Delete 4 to earn 4 points, consequently 3 is also deleted.
     Then, delete 2 to earn 2 points. 6 total points are earned.
     Example 2:
     Input: nums = [2, 2, 3, 3, 3, 4]
     Output: 9
     Explanation:
     Delete 3 to earn 3 points, deleting both 2's and the 4.
     Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
     9 total points are earned.
     Note:

     The length of nums is at most 20000.
     Each element nums[i] is an integer in the range [1, 10000].
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int n : nums) count[n]+=n;
        for (int i=2; i<count.length; ++i){
            count[i]=Math.max(count[i-2]+count[i], count[i-1]);
        }
        return count[10000];
    }

    /**
            *  其实这道题跟之前那道House Robber的本质是一样的，那道题小偷不能偷相邻的房子，这道题相邻的数字不能累加积分，是不是一个道理？那么对于每一
 *  个数字，我们都有两个选择，拿或者不拿。如果我们拿了当前的数字，我们就不能拿之前的数字（如果我们从小往大遍历就不需要考虑后面的数字），那么
 *  当前的积分就是不拿前面的数字的积分加上当前数字之和。如果我们不拿当前的数字，那么对于前面的数字我们既可以拿也可以不拿，于是当前的积分就是
 *  拿前面的数字的积分和不拿前面数字的积分中的较大值
 * **/
    public class DP_DeleteAndEarn {
        public int deleteAndEarn(int[] nums) {
            int[] sum = new int[10001];
            for (int num : nums) {
                sum[num] += num;
            }
            int take = 0, skip = 0;
            for (int i = 0; i < 10001; ++i) {
                int takei = skip + sum[i];
                int skipi = Math.max(skip, take);
                take = takei;
                skip = skipi;
            }
            return Math.max(take, skip);
        }
    }
}
