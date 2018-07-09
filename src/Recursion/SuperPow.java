package Recursion;
// Recursion

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is
 * an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8
 Example2:

 a = 2
 b = [1,0]

 Result: 1024
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        if (a==1) return 1;
        a %= 1337;
        int len = 0, res = 1;
        while (len<b.length){
            res = (pow(res, 10) * pow(a, b[len++])) % 1337;
            System.out.println(res);
        }
        return res;
    }

    private int pow (int a, int b){
        if (b==1) return a;
        if (b==0) return 1;
        int val = pow(a, b/2);
        int ret = (val * val)%1337;
        if (b%2==0) return ret;
        return (ret * a)%1337;
    }
}
