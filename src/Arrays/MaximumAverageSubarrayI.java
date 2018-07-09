package Arrays;
// TAG: Array
public class MaximumAverageSubarrayI {
    /**
     *  Given an array consisting of n integers, find the contiguous subarray of given length k
     *  that has the maximum average value. And you need to output the maximum average value.

     Example 1:

     Input: [1,12,-5,-6,50,3], k = 4
     Output: 12.75
     Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

     Note:

     1 <= k <= n <= 30,000.
     Elements of the given array will be in the range [-10,000, 10,000].

     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        double max=0.0, sum=0.0;
        for (int i=0; i<k; ++i){
            sum+=nums[i];
        }
        max=sum;
        for (int i=k; i<nums.length; ++i){
            sum += nums[i]-nums[i-k];
            if (sum>max) max=sum;
        }
        return max/k;
    }

    public double findMaxAverage2(int[] nums, int k) {
        Double res = null;
        int[] sum = new int[nums.length+1];
        for (int i=0; i<nums.length; ++i) sum[i+1]=sum[i]+nums[i];
        for (int i=k; i<sum.length; ++i){
            if (res==null) res = (double)(sum[i]-sum[i-k])/k;
            else res = Math.max(res, (double)(sum[i]-sum[i-k])/k);
        }
        return res;
    }
}
