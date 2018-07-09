package Bit;
// Bit
public class IntegerReplacement {
    /**
     *Given a positive integer n and you can do operations as follow:

     If n is even, replace n with n/2.
     If n is odd, you can replace n with either n + 1 or n - 1.
     What is the minimum number of replacements needed for n to become 1?
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        if (n==1) return 0;
        int res = helper((long)n);
        return res;
    }
    private int helper(long n){
        if (n==1) return 0;
        int res = 0;
        if (n%2==0){
            res = 1+helper(n>>1);
        }
        else {
            res = 1+Math.min(helper(n+1), helper(n-1));
        }
        return res;
    }

    public int integerReplacement2(int n) {
        int res = 0;
        while (n!=1){
            if ((n & 1)==0) n >>>= 1;
            else if (n==3 || ((n>>>1) & 1) ==0 ) n--;
            else n++;
            res++;
        }
        return res;
    }
}
