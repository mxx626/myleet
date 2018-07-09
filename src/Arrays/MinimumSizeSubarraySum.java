package Arrays;
// TAG: Array, Two POinter, Binary Search
public class MinimumSizeSubarraySum {
    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
     * subarray of which the sum ≥ s. If there isn't one, return 0 instead.

     For example, given the array [2,3,1,2,4,3] and s = 7,
     the subarray [4,3] has the minimal length under the problem constraint.

     click to show more practice.

     More practice:
     If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

     Credits:
     Special thanks to @Freezen for adding this problem and creating all test cases.


     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int sum=0;
        int minLen = Integer.MAX_VALUE;
        int slow=0;
        int fast=0;
        for (;fast<nums.length; ++fast){
            sum += nums[fast];
            while (sum >= s){
                minLen=Math.min(minLen, fast-slow+1);
                sum -= nums[slow++];
            }
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }

    //Binary Search
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int res = Integer.MAX_VALUE;
        int[] sum = new int[nums.length];
        for (int i=0; i<nums.length; ++i){
            sum[i] = nums[i];
            if (i==0) continue;
            sum[i] += sum[i-1];
            //   System.out.println(sum[i]);
        }

        for (int i=0; i<sum.length; ++i){
            int l=i;
            int r=sum.length-1;
            while (l+1<r){
                int m = l+(r-l)/2;
                if (sum[m]-sum[i]+nums[i]==s){
                    l=m;
                    break;
                }
                else if (sum[m]-sum[i]+nums[i]>s){
                    r=m;
                }
                else l=m;
            }
            if (sum[l]-sum[i]+nums[i]>=s) {
                res = Math.min(res, l-i+1);
            }
            else if (sum[r]-sum[i]+nums[i]>=s){
                res = Math.min(res, r-i+1);
            }
        }
        return res==Integer.MAX_VALUE ? 0 : res;
    }
}
