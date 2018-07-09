package Recursion;
// Recursion
/**
 * 625. Minimum Factorization

 Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.

 If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.

 Example 1
 Input:

 48
 Output:
 68
 Example 2
 Input:

 15
 Output:
 35
 */
public class MinimumFactorization {
    private int res = Integer.MAX_VALUE;
    public int smallestFactorization(int a) {
        if (a<10) return a;
        helper(0, a, 0, 9);
        return res==Integer.MAX_VALUE ? 0 : res;
    }
    private void helper(int sum, int num, int count, int s){
        if (count>=10) {
            res=0;
            return;
        }
        if (num==1 && sum>0){
            res = sum;
            return;
        }
        if (num%s==0){
            helper(sum+s*(int)Math.pow(10, count), num/s, count+1, s);
        }
        else {
            while (num%s!=0) s--;
            helper(sum+s*(int)Math.pow(10, count), num/s, count+1, s);
        }
    }
}
