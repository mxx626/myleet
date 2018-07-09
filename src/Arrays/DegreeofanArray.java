package Arrays;
import java.util.Arrays;
// TAG: Arrays
public class DegreeofanArray {
    /**
     * Given a non-empty array of non-negative integers nums, the degree of this array is
     * defined as the maximum frequency of any one of its elements.

     Your task is to find the smallest possible length of a (contiguous) subarray of nums,
     that has the same degree as nums.

     Example 1:
     Input: [1, 2, 2, 3, 1]
     Output: 2
     Explanation:
     The input array has a degree of 2 because both elements 1 and 2 appear twice.
     Of the subarrays that have the same degree:
     [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     The shortest length is 2. So return 2.
     Example 2:
     Input: [1,2,2,3,1,4,2]
     Output: 6
     Note:

     nums.length will be between 1 and 50,000.
     nums[i] will be an integer between 0 and 49,999.
     * @param nums
     * @return
     */

    //Slower
    public int findShortestSubArray(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] count = new int[max+1];
        int[][] index = new int[max+1][2];
        int max1 = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; ++i){
            if (count[nums[i]]==0){
                index[nums[i]][0]=i;
                index[nums[i]][1]=i;
            }
            else index[nums[i]][1]=i;
            count[nums[i]]++;
            max1 = Math.max(max1, count[nums[i]]);
        }
        for (int i=0; i<nums.length; ++i){
            if (count[nums[i]]==max1){
                res = Math.min(res, index[nums[i]][1]-index[nums[i]][0]+1);
            }
        }
        return res;
    }

    public int findShortestSubArray2(int[] nums) {
        int min=50000, max=-1;
        for (int n : nums){
            if (n>max) max=n;
            if (n<min) min=n;
        }
        int[][] count = new int[max-min+1][3];
        for (int i=0; i<count.length; ++i) count[i][0]=-1;
        int mfreq=0;
        for (int i=0; i<nums.length; ++i){
            int idx=nums[i]-min;
            if (count[idx][0]==-1){
                count[idx][0]=i;
                count[idx][1]=i;
            }
            else{
                count[idx][1]=i;
            }
            count[idx][2]++;
            if (count[idx][2]>mfreq) mfreq=count[idx][2];
        }
        int res = 50000;
        for (int i=0; i<count.length; ++i){
            if (count[i][2]==mfreq){
                res = Math.min(count[i][1]-count[i][0]+1, res);
            }
        }
        return res;
    }
}
