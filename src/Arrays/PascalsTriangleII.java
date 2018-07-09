package Arrays;
// TAG: Arrays
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
    /**
     * Given an index k, return the kth row of the Pascal's triangle.

     For example, given k = 3,
     Return [1,3,3,1].

     Note:
     Could you optimize your algorithm to use only O(k) extra space?
     */
    private List<Integer> list = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        helper(rowIndex, Arrays.asList(1));
        return list;
    }
    private void helper (int idx, List<Integer> last){
        if (idx<=0) {
            list = new ArrayList<>(last);
            return;
        }
        List<Integer> next = new ArrayList<>();
        for (int i=0; i<last.size()+1; ++i){
            if (i==0) next.add(last.get(i));
            else if (i==last.size()) next.add(last.get(i-1));
            else {
                next.add(last.get(i)+last.get(i-1));
            }
        }
        helper(idx-1, next);
    }
}
