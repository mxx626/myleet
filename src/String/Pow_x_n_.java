package String;
// TAG: Math, BinarySearch
public class Pow_x_n_ {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (xn).

     Example 1:

     Input: 2.00000, 10
     Output: 1024.00000
     Example 2:

     Input: 2.10000, 3
     Output: 9.26100
     Example 3:

     Input: 2.00000, -2
     Output: 0.25000
     Explanation: 2-2 = 1/22 = 1/4 = 0.25
     Note:

     -100.0 < x < 100.0
     n is a 32-bit signed integer, within the range [−231, 231 − 1]
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x==0.0) return 0.0;
        if (x==1.0) return 1.0;
        if (n<0) x = 1/x;
        long m = Math.abs((long)n);
        return calPow(x, m);
    }
    private double calPow (double x, long n){
        if (n==0) return 1.0;
        double res=0.0;
        double half = calPow(x, n/2);
        if (n%2==1){
            res = half*half*x;
        }
        else if (n%2==0){
            res = half*half;
        }
        return res;
    }
}
