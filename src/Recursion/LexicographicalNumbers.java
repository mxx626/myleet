package Recursion;
// REcursion
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    /**
     * Given an integer n, return 1 - n in lexicographical order.

     For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

     Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i=1; i<=9; ++i){
            if (i>n) break;
            res.add(i);
            helper(i*10, (i+1)*10-1, res, n);
        }
        return res;
    }

    private void helper(int s, int e, List<Integer> res, int n){
        if (s>e || s>n) return;
        for (int i=s; i<=e; ++i){
            if (i>n) break;
            res.add(i);
            helper(i*10, (i+1)*10-1, res, n);
        }
    }



    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for (int i=0; i<n; ++i){
            res.add(cur);
            if (cur*10<=n){
                cur = cur*10;
            }
            else {
                if (cur>=n) cur/=10;
                cur++;
                while (cur%10==0) cur/=10;
            }
        }
        return res;
    }
}
