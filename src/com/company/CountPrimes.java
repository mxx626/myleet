package com.company;
// HashTable, Math
/**
 * 204. Count Primes

 Count the number of prime numbers less than a non-negative number, n.

 Example:

 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 https://www.geeksforgeeks.org/sieve-of-eratosthenes/

 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n<=2) return 0;
        boolean[] prime = new boolean[n+1];
        int res = 1;
        for (int i=3; i<n; i+=2){
            if (!prime[i]){
                res++;
                for (int j=i*2; j<n; j+=i){
                    prime[j]=true;
                }
            }
        }
        return res;
    }
}
