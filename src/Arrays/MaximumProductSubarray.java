package Arrays;

public class MaximumProductSubarray {
    /**
     *
     * @param nums
     * @return
     */
    //[-2,3,0,5,-3,-2,5,-5]

    /**
     *        -2,   3,     0,    5,   -3,   -2,   5,   -5
     *   max  -2    3      0     5   -15    30    150
     *   min  -2    -6     0     5   -15    30    150
     *
     * **/
    public int maxProduct(int[] nums) {
        int max=nums[0], min=nums[0];
        int res=max;
        for (int i=1; i<nums.length; ++i){
            int tmp = max;
            max = Math.max(max*nums[i], Math.max(min*nums[i], nums[i]));
            min = Math.min(tmp*nums[i], Math.min(min*nums[i], nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res=nums[0];
        max[0]=nums[0]; min[0]=nums[0];
        for (int i=1; i<nums.length; ++i){
            max[i]=Math.max(max[i-1]*nums[i], Math.max(min[i-1]*nums[i], nums[i]));
            min[i]=Math.min(max[i-1]*nums[i], Math.min(min[i-1]*nums[i], nums[i]));
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
