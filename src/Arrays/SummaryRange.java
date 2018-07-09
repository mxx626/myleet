package Arrays;
// TAG: Array, Two POinter
import java.util.LinkedList;
import java.util.List;

public class SummaryRange {
    /**
     *  Given a sorted integer array without duplicates, return the summary of its ranges.

     Example 1:

     Input: [0,1,2,4,5,7]
     Output: ["0->2","4->5","7"]

     Example 2:

     Input: [0,2,3,4,6,8,9]
     Output: ["0","2->4","6","8->9"]

     Credits:
     Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> list = new LinkedList<>();
        if (nums==null || nums.length==0) return list;
        for (int i=0; i<nums.length; ++i){
            int cur = nums[i];
            while (i+1<nums.length && nums[i+1]==nums[i]+1) i++;
            if (cur !=nums[i]){
                list.add(cur + "->" + nums[i]);
            }
            else list.add(cur + "");
        }
        return list;
    }
}
