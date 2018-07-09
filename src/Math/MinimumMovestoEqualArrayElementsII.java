package Math;
//Math
import java.util.Arrays;
public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long sum=0;
        for (int n : nums){
            sum += n-nums[0];
        }
        long left = 0, right=sum;
        for (int i=1; i<nums.length; ++i){
            right -= (nums.length-i)*(nums[i]-nums[i-1]);
            left += i*(nums[i]-nums[i-1]);
            sum = Math.min(sum, left+right);
        }
        return (int)sum;
    }
}
