package Arrays;
// TAG: Array, Moore Vote Algorithm
import java.util.ArrayList;
import java.util.List;

public class MajorElementII {
    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * The algorithm should run in linear time and in O(1) space.

     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums==null || nums.length==0) return list;
        int number1=0, number2=0;
        int count1=0, count2=0;
        for (int i=0; i<nums.length; ++i){
            if (nums[i]==number1){
                count1++;
            }
            else if (nums[i]==number2){
                count2++;
            }
            else if (count1==0){
                number1=nums[i];
                count1=1;
            }
            else if (count2==0){
                number2=nums[i];
                count2=1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0; count2=0;
        for (int n : nums){
            if (n==number1) count1++;
            else if (n==number2) count2++;
        }
        if (count1>nums.length/3) list.add(number1);
        if (count2>nums.length/3) list.add(number2);
        return list;
    }
}
