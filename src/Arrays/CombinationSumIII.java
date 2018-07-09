package Arrays;
// TAG: Array, Backtracking
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    /**
     * Find all possible combinations of k numbers that add up to a number n, given that only
     * numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


     Example 1:

     Input: k = 3, n = 7

     Output:

     [[1,2,4]]

     Example 2:

     Input: k = 3, n = 9

     Output:

     [[1,2,6], [1,3,5], [2,3,4]]
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        helper(res, list, k, n, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int k, int n, int start){
        if (n==0 && k==0){
            res.add(new LinkedList<>(list));
        }
        else if (n<0 || k<0) return;
        for (int i=start; i<=9; i++){
            list.offer(i);
            helper(res, list, k-1, n-i, i+1);
            list.pollLast();
        }
    }
}
