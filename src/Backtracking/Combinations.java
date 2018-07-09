package Backtracking;
// Backtracking
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> ret = new ArrayList<>();

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

     Example:

     Input: n = 4, k = 2
     Output:
     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        helper(n, 1, new ArrayList<>(), k);
        return ret;
    }
    private void helper(int n,int start, List<Integer> list, int k){
        if (list.size()==k) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<=n; ++i){
            list.add(i);
            helper(n, i+1, list, k);
            list.remove(list.size()-1);
        }
    }
}
