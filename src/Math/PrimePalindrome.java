package Math;
// Math
/**
 * 867. Prime Palindrome

 Find the smallest prime palindrome greater than or equal to N.

 Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.

 For example, 2,3,5,7,11 and 13 are primes.

 Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.

 For example, 12321 is a palindrome.



 Example 1:

 Input: 6
 Output: 7
 Example 2:

 Input: 8
 Output: 11
 Example 3:

 Input: 13
 Output: 101


 Note:

 1 <= N <= 10^8
 The answer is guaranteed to exist and be less than 2 * 10^8.
 */
public class PrimePalindrome {
    public int primePalindrome(int N) {
        if (N==1 || N==2) return 2;
        if (N%2==0) N++;
        while (true){
            if (isPalin(N) && isPrime(N)) return N;
            N=N+2;
            if (10_000_000<N && N<100_000_000)
                N=100_000_001;
        }
    }
    private boolean isPalin(int N){
        int res = 0;
        int cur = N;
        while (cur>0){
            res = res*10+cur%10;
            cur /= 10;
        }

        return N==res;
    }

    private boolean isPrime(int N){
        if (N==1) return false;
        if (N<4) return true;
        if (N%2==0 || N%3==0) return false;
        for (int i=5; i*i<=N; i+=6){
            if (N%i==0 || (N%(i+2)==0)) return false;
        }
        return true;
    }
}
