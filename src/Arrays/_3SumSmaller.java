package Arrays;
// TAG: Array, Two Pointer
import java.util.Arrays;
public class _3SumSmaller {
    /**
     * Given an array of n integers nums and a target, find the number of index triplets
     * i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

     For example, given nums = [-2, 0, 1, 3], and target = 2.

     Return 2. Because there are two triplets which sums are less than 2:

     [-2, 0, 1]
     [-2, 0, 3]

     Follow up:
     Could you solve it in O(n2) runtime?
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        //    if (nums==null || nums.length<3) return 0;
        int count=0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; ++i){
            //        if (i!=0 && nums[i]==nums[i-1]) continue;
            int j=i+1, k=nums.length-1;
            int sum=target-nums[i];
            while (j<k){
                if (sum<=nums[j]+nums[k]){
                    // do{
                    //     k--;
                    // }while(j<k && k!=nums.length-1 && nums[k]==nums[k+1]);
                    k--;
                }
                else {
                    count += k-j;
                    j++;
                    // do{
                    //     j++;
                    // }while (j<k && nums[j]==nums[j-1]);
                }
            }
        }
        return count;
    }
}
