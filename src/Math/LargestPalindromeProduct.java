package Math;
// Math
public class LargestPalindromeProduct {
    /**
     * Find the largest palindrome made from the product of two n-digit numbers.

     Since the result could be very large, you should return the largest palindrome mod 1337.

     Example:

     Input: 2

     Output: 987

     Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

     Note:

     The range of n is [1,8].
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if (n==1) return 9;
        long max = (long)Math.pow(10, n)-1;
        for (long num=max; num>max/10; --num){
            long tmp = helper(num);
            for (long res=max; res*res>=tmp; --res){
                if (tmp%res==0){
                    return (int)(tmp%1337);
                }
            }
        }
        return 0;
    }
    private long helper(long num){
        long x = num;
        while (x>1){
            num = num*10+x%10;
            x /= 10;
        }
        return num;
    }
}
