package Arrays;
// TAG: Arrays, Two Pointers, DFS
import java.util.HashSet;

public class SplitArraywithEqualSum {
    /**
     * Given an array with n integers, you need to find if there are triplets (i, j, k)
     * which satisfies following conditions:

     0 < i, i + 1 < j, j + 1 < k < n - 1
     Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1)
     should be equal.
     where we define that subarray (L, R) represents a slice of the original array starting
     from the element indexed L to the element indexed R.
     Example:
     Input: [1,2,1,2,1,2,1]
     Output: True
     Explanation:
     i = 1, j = 3, k = 5.
     sum(0, i - 1) = sum(0, 0) = 1
     sum(i + 1, j - 1) = sum(2, 2) = 1
     sum(j + 1, k - 1) = sum(4, 4) = 1
     sum(k + 1, n - 1) = sum(6, 6) = 1
     Note:
     1 <= n <= 2000.
     Elements in the given array will be in range [-1,000,000, 1,000,000].
     * @param nums
     * @return
     */
    public boolean splitArray(int[] nums) {
        if (nums.length<7) return false;
        int[] sum = new int[nums.length];
        for (int i=0; i<nums.length; ++i){
            sum[i]=nums[i];
            if (i==0) continue;
            sum[i]+=sum[i-1];
        }
        for (int m=3; m+3<nums.length; ++m){
            if (m !=3 && nums[m-1]==0 && nums[m]==0) continue;
            HashSet<Integer> set = new HashSet<>();
            for (int f=1; f+1<m; ++f){
                if (nums[f-1]==0) continue;
                if (sum[f-1]==sum[m-1]-sum[f])
                    set.add(sum[f-1]);
            }
            for (int t=m+2; t<nums.length-1; ++t){
                if (nums[t-1]==0) continue;
                if ((sum[t-1]-sum[m]==sum[nums.length-1]-sum[t]) && set.contains(sum[t-1]-sum[m]))
                    return true;
            }
        }
        return false;
    }
}
