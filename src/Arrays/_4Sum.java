package Arrays;

// TAG: Arrays, Two Pointer, HashTable
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class _4Sum {
    /**
     * Given an array S of n integers, are there elements a, b, c, and d in S such
     * that a + b + c + d = target? Find all unique quadruplets in the array which
     * gives the sum of target.

     Note: The solution set must not contain duplicate quadruplets.

     For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

     A solution set is:
     [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
     ]
     */
    // Better
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums==null || nums.length<4) return res;
        Arrays.sort(nums);
        if (nums[0]*4>target || nums[nums.length-1]*4 < target) return res;
        int t = target;
        for (int i=0; i<nums.length-3; ++i){
            if (i!=0 && nums[i]==nums[i-1]) continue;
            if (nums[i]*4 > target) break;
            target -= nums[i];
            for (int j=i+1; j<nums.length-2; ++j){
                if (j!=i+1 && nums[j]==nums[j-1]) continue;
                if (nums[j]*3>target || nums[nums.length-1]*3<target) break;
                int m=j+1, n=nums.length-1;
                target -= nums[j];
                while (m<n){
                    if (target==nums[m]+nums[n]){
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++; n--;
                        while (m<n && nums[m]==nums[m-1]) m++;
                        while (m<n && n!=nums.length-1 && nums[n]==nums[n+1]) n--;
                    }
                    else if (target < nums[m]+nums[n]){
                        n--;
                    }
                    else {
                        m++;
                    }
                }
                target += nums[j];
            }
            target = t;
        }
        return res;
    }



    /////////////////////////////////////////////////////////////////////////////////////
    private List<List<Integer>> res = null;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new LinkedList<>();
        if (nums.length<4) return res;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-3; ++i){
            if (i!=0 && nums[i]==nums[i-1]) continue;
            for (int j=i+1; j<nums.length-2; ++j){
                if (j!=i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1, l=nums.length-1;
                int sum = target-nums[i]-nums[j];
                while (k<l){
                    if (sum==nums[k]+nums[l]){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;
                        while (k<l && nums[k]==nums[k-1]) k++;
                        while (k<l && l!=nums.length-1 && nums[l]==nums[l+1]) l--;
                    }
                    else if (sum>nums[k]+nums[l]){
                        k++;
                        while (k<l && nums[k]==nums[k-1]) k++;
                    }
                    else {
                        l--;
                        while (k<l && l!=nums.length-1 && nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        return res;
    }
}