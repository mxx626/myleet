package Backtracking;
// Backtracking
import java.util.ArrayList;
import java.util.List;

/**
 * 254. Factor Combinations

 Numbers can be regarded as product of its factors. For example,

 8 = 2 x 2 x 2;
 = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:

 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.
 Example 1:

 Input: 1
 Output: []
 Example 2:

 Input: 37
 Output:[]
 Example 3:

 Input: 12
 Output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]
 Example 4:

 Input: 32
 Output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        if (n==1 || isPrime(n)) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> factors, int num, int s){
        if (num==1 && factors.size()>1){
            res.add(new ArrayList<>(factors));
            return;
        }
        if (num!=1){
            factors.add(num);
            helper(res, factors, 1, s);
            factors.remove(factors.size()-1);
        }
        for (int i=s; i*i<=num; ++i){
            if (num%i==0){
                factors.add(i);
                helper(res, factors, num/i, i);
                factors.remove(factors.size()-1);
            }
        }
    }
    private boolean isPrime (int n){
        if (n==1) return false;
        if (n==2 || n==3) return true;
        if (n%2==0 || n%3==0) return false;
        for (int i=5; i*i<=n; i+=6){
            if (n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }
}
