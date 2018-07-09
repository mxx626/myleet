package Math;
// Math
public class ReverseInteger {
    /**
     * Given a 32-bit signed integer, reverse digits of an integer.

     Example 1:

     Input: 123
     Output: 321
     Example 2:

     Input: -123
     Output: -321
     Example 3:

     Input: 120
     Output: 21
     Note:
     Assume we are dealing with an environment which could only store integers within the 32-bit signed
     integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns
     0 when the reversed integer overflows.
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        boolean isNegative = x<0 ? true : false;
        x = Math.abs(x);
        while(x>0){
            if (res>(Integer.MAX_VALUE-x%10)/10) return 0;
            res = res*10+x%10;
            x=x/10;
        }

        return isNegative ? (int)-res : (int)res;
    }
}
