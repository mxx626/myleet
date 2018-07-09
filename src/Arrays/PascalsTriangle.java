package Arrays;
// TAG: Array, Recursion
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    /**
     * Given numRows, generate the first numRows of Pascal's triangle.

     For example, given numRows = 5,
     Return

     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]

     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        helper(numRows, new int[]{1});
        return res;
    }
    public void helper (int numRow, int[] last){
        if (numRow<=0) return;
        List<Integer> list = new LinkedList<>();
        for (int n : last){
            list.add(n);
        }
        res.add(list);
        int[] next = new int[last.length+1];
        for (int i=0; i<next.length; ++i){
            if (i==0) next[i]=last[i];
            else if (i==next.length-1) next[i]=last[i-1];
            else{
                next[i]=last[i-1]+last[i];
            }
        }
        helper(numRow-1, next);
    }
}
