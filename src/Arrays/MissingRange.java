package Arrays;
// TAG: Array
import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    /**
     * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
     * return its missing ranges.

     For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].


     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        long l=(long)lower, u=(long)upper;
        for (int n : nums){
            if (n==l){
                l++;
            }
            else if(l<n) {
                if (l+1==n){
                    list.add(l+"");
                }
                else {
                    list.add(l+"->"+(n-1));
                }
                l=(long)n+1;
            }
        }
        if (l==(long)upper) list.add(l+"");
        else if (l<(long)upper) list.add(l+"->"+upper);

        return list;
    }
}
